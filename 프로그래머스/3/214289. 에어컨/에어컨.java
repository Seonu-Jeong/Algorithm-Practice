import java.util.*;
class Solution {
    
    final int MAX = 100000000;
    
    int temperature, t1, t2, a, b;
    int[] onboard;
    
    int[][] cache;
    
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        this.temperature = temperature; this.t1=t1; this.t2=t2; this.a=a; this.b=b;
        this.onboard=onboard;
        
        cache = new int[51][onboard.length+1];
        for(int i=0; i<51; i++)
            Arrays.fill(cache[i],-1);
        
        int answer = dp(temperature, 0);
        return answer;
    }
    
    int dp(int curTemp, int idx) {
        
        if(idx==onboard.length){
            return 0;
        }
        
        if(onboard[idx]==1)
            if(curTemp<t1 || curTemp>t2)
                return MAX;
        
        if(cache[curTemp+10][idx]!=-1)
            return cache[curTemp+10][idx];
        
        int offNext=0;
        
        if(curTemp<temperature)
            offNext=1;
        else if(curTemp>temperature)
            offNext=-1;
        
        int result = MAX;
        
        result = Math.min(result, dp(curTemp+offNext, idx+1));
        result = Math.min(result, dp(curTemp, idx+1)+b);
        
        if(curTemp<40){
            result = Math.min(result, dp(curTemp+1, idx+1)+a);
        }
        if(curTemp>-10)
            result = Math.min(result, dp(curTemp-1, idx+1)+a);
        
        //System.out.printf("curTemp:%d, idx:%d, result:%d\n", curTemp, idx, result);
        cache[curTemp+10][idx] = result;
        return result;
    }
}