import java.util.*;
class Solution {
    
    final int MAX = 100_000_000;
    final int MIN = -100_000_000;
    
    String arr[];
    
    int cache_max[][];
    int cache_min[][];
    
    public int solution(String arr[]) {
        
        // 초기화
        
        int answer = -1;
        
        this.arr = arr;
        
        int n = arr.length;
        
        cache_max = new int[n][n];
        for(int i=0; i<n; i++)
            Arrays.fill(cache_max[i], MIN);
        
        cache_min = new int[n][n];
        for(int i=0; i<n; i++)
            Arrays.fill(cache_min[i], MAX);
        
        // 뺄셈이 없으면
        if(!isHaveMinus(arr)) {
            int sum = 0;
            
            for(String str : arr) {
                if(!str.equals("-") && !str.equals("+"))
                    sum += Integer.parseInt(str);
            }
            
            answer = sum;
            return answer;
        }
        
        // 뺄셈이 있음
        answer = dpMax(0, arr.length-1);
            
        return answer;
    }
    
    int dpMax(int le, int ri) {
        
        if(le==ri) {
            return Integer.parseInt(arr[le]);
        }
        
        if(cache_max[le][ri]!=MIN) {
            return cache_max[le][ri];
        }
        
        int result = MIN;
        for(int mid=le; mid<ri; mid+=2) {
            if(arr[mid+1].equals("+")) {
                int ret2 = dpMax(mid+2, ri);
                int ret1 = dpMax(le, mid);
                
                result = Math.max(result, ret1+ret2);
            }
            else {
                int ret2 = dpMin(mid+2, ri);
                int ret1 = dpMax(le, mid);
                
                result = Math.max(result, ret1-ret2);
            }
        }
        
        cache_max[le][ri] = result;
        return result;
    }
    
    int dpMin(int le, int ri) {
        
        if(le==ri) {
            return Integer.parseInt(arr[le]);
        }
        
        if(cache_min[le][ri]!=MAX)
            return cache_min[le][ri];
        
        int result = MAX;
        for(int mid=le; mid<ri; mid+=2) {
            
            if(arr[mid+1].equals("+")) {
                int ret2 = dpMin(mid+2, ri);
                int ret1 = dpMin(le, mid);
                
                result = Math.min(result, ret1+ret2);
            }
            else {
                int ret2 = dpMax(mid+2, ri);
                int ret1 = dpMin(le, mid);
                
                result = Math.min(result, ret1-ret2);
            }
        }
        
        cache_min[le][ri] = result;
        return result;
    }
    
    boolean isHaveMinus(String arr[]) {
        for(String str : arr) {
            if(str.equals("-"))
                return true;
        }
        
        return false;
    }
}

/*
- 식에 뺄셈이 있으면 연산 순서에 따라 다른 결과가 나옴

- 결과 : 다른 순서의 연산 결과 중 최대값을 리턴

- 
*/