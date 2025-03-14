import java.util.*;
class Solution {
    public int[] solution(String myString) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int len = 0;
        
        for(int i=0; i<myString.length(); i++) {
            if(myString.charAt(i)=='x'){
                answer.add(len);
                len=0;
            }
            else
                len++;
        }
        
        answer.add(len);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}