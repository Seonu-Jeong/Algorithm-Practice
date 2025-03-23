import java.util.*;
class Solution {
    public String[] solution(String myString) {
        ArrayList<String> answer = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        
        for(char ch : myString.toCharArray()) {
            if(ch == 'x') {
                if(sb.length()!=0){
                    answer.add(sb.toString());
                    sb = new StringBuilder();
                }
                continue;
            }
            
            sb.append(ch);
        }
        
        if(sb.length()!=0) {
            answer.add(sb.toString());    
        }
        
        Collections.sort(answer);
        
        return answer.stream().toArray(String[]::new);
    }
}