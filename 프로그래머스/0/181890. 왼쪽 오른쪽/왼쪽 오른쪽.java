import java.util.*;
class Solution {
    public String[] solution(String[] str_list) {
        String[] answer = {};
        
        int len = str_list.length;
        
        for(int i=0; i<len; i++) {
            if(str_list[i].equals("l")) {
                answer = Arrays.copyOfRange(str_list, 0, i);
                break;
            }
            else if(str_list[i].equals("r")) {
                answer = Arrays.copyOfRange(str_list, i+1, len);
                break;
            }
        }
        
        return answer;
    }
}