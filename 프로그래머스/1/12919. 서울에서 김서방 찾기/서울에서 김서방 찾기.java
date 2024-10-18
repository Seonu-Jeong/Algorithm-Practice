import java.util.*;

class Solution {
    public String solution(String[] seoul) {
        int i=0;
        for(; i<seoul.length; i++){
            if(seoul[i].equals("Kim"))
                break;    
        }
        
        return "김서방은 "+i+"에 있다";
    }
    
}