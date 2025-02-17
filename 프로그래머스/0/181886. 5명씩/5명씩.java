import java.util.*;
class Solution {
    public String[] solution(String[] names) {
        ArrayList<String> answer = new ArrayList<>();
        
        for(int i=0;i<names.length; i++) {
            int a = i+1;
            
            if(i%5==0)
                answer.add(names[i]);
        }
        
        return answer.toArray(new String[1]);
    }
}