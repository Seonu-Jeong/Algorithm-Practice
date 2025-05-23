import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] words = new String[]{"aya", "ye", "woo", "ma"};
        int cnt=0;
        for(String origin : babbling) {
            
            boolean[] visited = new boolean[origin.length()];
            
            for(String word: words) {
                isContain(origin, word, visited);        
            }
            
            boolean canSpeak = true;
            for(int i=0; i<visited.length; i++) {
                if(!visited[i]) {
                    canSpeak=false;
                    break;
                }
            }
            
            if(canSpeak)
                cnt++;
            
            //System.out.println(cnt);
        }
        
        answer = cnt;
        
        return answer;
    }
    
    boolean isContain(String original, String word, boolean[] visited) {
        
        for(int i=0; i<original.length(); i++) {
            if(visited[i]) continue;
            
            if(original.charAt(i)!=word.charAt(0)) continue;
            
            
            boolean flag=false;
            for(int j=0; j<word.length() && i+j < original.length(); j++) {
                if(visited[j+i]) flag=true;
            }
            
            if(flag) continue;
            
            int end = (i+word.length())>original.length()?original.length():(i+word.length());
            
            if(original.substring(i,end).equals(word)) {
                for(int j=0; j<word.length(); j++) {
                    visited[j+i]=true;
                }
                
                return true;
            }
        }
        
        return false;
    }
}