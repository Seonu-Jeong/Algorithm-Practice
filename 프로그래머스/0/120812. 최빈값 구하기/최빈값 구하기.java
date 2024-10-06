import java.util.*;

class Solution {
    public int solution(int[] array) {
        int[] cnt = new int[1001];
        
        int ret_value = -1;
        int ret_cnt = 0;
        
        for(int idx : array){
            cnt[idx]++;
            
            if(ret_cnt < cnt[idx]){
                ret_cnt = cnt[idx];
                ret_value = idx;
            }
        }
        
        int check=0;
        for(int x : cnt){
            if(ret_cnt==x)
                check++;
        }
        
        if(check>1) 
            return -1;
        else
            return ret_value;
        
    }
}