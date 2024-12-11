import java.util.*;
class Solution {
    public String solution(int q, int r, String code) {
        StringBuilder answer = new StringBuilder("");
        
        for(int i=0; i<code.length(); i++){
            if(i%q!=r) continue;
            
            answer.append(code.charAt(i));
        }
        
        return answer.toString();
    }
}