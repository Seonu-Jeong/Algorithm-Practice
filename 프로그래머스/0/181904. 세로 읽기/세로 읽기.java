import java.util.*;

class Solution {
    public String solution(String my_string, int m, int c) {
        StringBuilder answer = new StringBuilder("");
        
        for(int i=0; i<my_string.length(); i++){
            if(i%m==c-1){
                answer.append(my_string.charAt(i));
            }    
        }
        
        return answer.toString();
    }
}