import java.util.*;
class Solution {
    public String solution(String myString) {
        StringBuilder answer = new StringBuilder("");
        
        for(int i=0; i<myString.length(); i++) {
            char ch = myString.charAt(i);
            if(ch=='a')
                answer.append('A');
            
            else if(ch>='B'&&ch<='Z'){
                answer.append((char)(ch-'A'+'a'));
            }
            
            else
                answer.append(ch);
        }
        
        return answer.toString();
    }
}