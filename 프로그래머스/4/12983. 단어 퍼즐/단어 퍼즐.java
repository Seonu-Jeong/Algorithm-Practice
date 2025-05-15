import java.util.*;
class Solution {
    
    Set<String> set = new TreeSet<>();
    int[] cache;
    
    public int solution(String[] strs, String t) {
        for(String str : strs) {
            set.add(str);
        }
        cache = new int[t.length()];
        Arrays.fill(cache, -1);
        
        int result = dp(t, t.length()-1);
        
        if(result==Integer.MAX_VALUE)
            return -1;
        
        return result;
    }
    
    int dp(String str, int pos) {
        
        if(pos<0)
            return 0;
        
        if(cache[pos]!=-1)
            return cache[pos];
        
        int result = Integer.MAX_VALUE;
        
        for(int i=pos; i>=0; i--) {
            String sub = str.substring(i,pos+1);
            
            if(sub.length()>5)
                break;
            
            if(!set.contains(sub))
                continue;
            
            int ret = dp(str, i-1);
            
            if(ret==Integer.MAX_VALUE)
                continue;
        
            result = Math.min(result, ret+1);
        }
        
        cache[pos]=result;
        return result;
    }
}