import java.util.*;
class Solution {
    public int[][] solution(int[][] rc, String[] operations) {
        int[][] answer = {};
        
        ArrayDeque<Integer> left = leftQueue(rc);
        ArrayDeque<Integer> right = rightQueue(rc);
        ArrayDeque<ArrayDeque<Integer>> middle = middleQueue(rc);
        
        for(String op : operations) {
            if(op.equals("ShiftRow")) shift(left, right, middle);
            else rotate(left, right, middle);
        }
        
        answer = makeMatric(left, right, middle);
        
        return answer;
    }
    
    int[][] makeMatric(ArrayDeque<Integer> left, ArrayDeque<Integer> right,
                    ArrayDeque<ArrayDeque<Integer>> middle) {
        
        int n = left.size();
        int m = 2 + middle.peek().size();
        
        int[][] result = new int[n][m];
        
        for(int i=0; i<n; i++) {
            
            result[i][0] = left.pop();
            
            for(int j=1; j<=m-2; j++) {
                result[i][j] = middle.peek().pop();
            }
            
            middle.pop();
            
            result[i][m-1] = right.pop();
        }
        
        return result;
    }
    
    void rotate(ArrayDeque<Integer> left, ArrayDeque<Integer> right, ArrayDeque<ArrayDeque<Integer>> middle) {
        
        middle.getFirst().addFirst(left.removeFirst());
        
        right.addFirst(middle.getFirst().removeLast());
        
        middle.getLast().addLast(right.removeLast());
        
        left.addLast(middle.getLast().removeFirst());
    }
    
    void shift(ArrayDeque<Integer> left, ArrayDeque<Integer> right, ArrayDeque<ArrayDeque<Integer>> middle) {
        left.addFirst(left.removeLast());
        right.addFirst(right.removeLast());
        middle.addFirst(middle.removeLast());
    }
    
    
    ArrayDeque<Integer> leftQueue(int[][] rc) {
        
        ArrayDeque<Integer> result = new ArrayDeque<>();
        
        int n = rc.length;
        
        for(int i=0; i<n; i++) {
            result.offer(rc[i][0]);
        }
        
        return result;
    }
    
    ArrayDeque<Integer> rightQueue(int[][] rc) {
        
        ArrayDeque<Integer> result = new ArrayDeque<>();
        
        int n = rc.length;
        int m = rc[0].length;
        
        for(int i=0; i<n; i++) {
            result.offer(rc[i][m-1]);
        }
        
        return result;
    }
    
    ArrayDeque<ArrayDeque<Integer>> middleQueue(int[][] rc) {
        
        ArrayDeque<ArrayDeque<Integer>> result = new ArrayDeque<>();
        
        int n = rc.length;
        int m = rc[0].length;
        
        for(int i=0; i<n; i++) {
            ArrayDeque<Integer> middle = new ArrayDeque<>();
            
            for(int j=1; j<m-1; j++) {
                middle.offer(rc[i][j]);
            }
            
            result.offer(middle);
        }
        
        return result;
    }
}