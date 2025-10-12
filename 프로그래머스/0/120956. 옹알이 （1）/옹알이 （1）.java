import java.util.*;

class Solution {
    
    String[] words = new String[]{"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        Set<String> word_set = new TreeSet<>();
        for(String s: words) 
            word_set.add(s);
        
        for(String s: babbling) {
            Set<String> used = new TreeSet<>();
            
            int le=0, ri=1;
            
            while(ri<=s.length()) {
                
                String sub = s.substring(le, ri);
                
                if(word_set.contains(sub)) {
                    if(used.contains(sub))
                        break;
                    else {
                        used.add(sub);
                        le=ri;
                    }
                }
                
                ri++;
            }
            
            if(le==s.length())
                answer++;
            
        }
        
        return answer;
    }
}