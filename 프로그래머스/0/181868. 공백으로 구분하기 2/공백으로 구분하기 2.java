import java.util.*;
class Solution {
    public String[] solution(String my_string) {
        ArrayList<String> answer = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(my_string);
        
        while(st.hasMoreTokens()){
            answer.add(st.nextToken());
        }
        
        return answer.stream().toArray(String[]::new);
    }
}