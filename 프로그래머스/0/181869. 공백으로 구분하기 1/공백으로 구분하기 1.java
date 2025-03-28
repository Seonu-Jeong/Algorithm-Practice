import java.util.*;
class Solution {
    public String[] solution(String my_string) {
        StringTokenizer st = new StringTokenizer(my_string);
        
        ArrayList<String> answer = new ArrayList<>();
        
        while(st.hasMoreTokens()){
            answer.add(st.nextToken());
        }
        
        return answer.stream().toArray(String[]::new);
    }
}