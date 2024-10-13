import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        int[] lpi = new int[26];
        Arrays.fill(lpi,-1);
        
        int[] ret = new int[s.length()];
        
        char[] alpa = s.toCharArray();
        
        for(int i=0;i<alpa.length;i++){
            char ch = alpa[i];
            
            if(lpi[ch-'a']==-1)
                ret[i]=-1;
            else
                ret[i]=i-lpi[ch-'a'];
            
            lpi[ch-'a']=i;
        }
        
        return ret;
    }
}