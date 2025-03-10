import java.util.*;
class Solution {
    public String[] solution(String[] strArr) {
        ArrayList<String> answer = new ArrayList<>();
        
        for(String str : strArr) {
            if(str.indexOf("ad")==-1)    
                answer.add(str);
        }
        
        return answer.stream().toArray(String[]::new);
    }
}