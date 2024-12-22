import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        boolean[] isNotRead = new boolean[my_string.length()];
        
        for(int idx : indices) {
            isNotRead[idx] = true;
        }
        
        StringBuilder answer = new StringBuilder();
        
        for(int i=0; i<my_string.length(); i++){
            if(isNotRead[i]) continue;
            
            answer.append(my_string.charAt(i));
        }
        
        return answer.toString();
    }
}