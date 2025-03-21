import java.util.*;
class Solution {
    public String solution(String my_string, String alp) {
        StringBuilder answer = new StringBuilder("");
        
        char alp_ch = alp.charAt(0);
        for(char ch : my_string.toCharArray()) {
            if(ch==alp_ch)
                answer.append((char)('A'+ch-'a'));
            else
                answer.append(ch);
        }
        return answer.toString();
    }
}