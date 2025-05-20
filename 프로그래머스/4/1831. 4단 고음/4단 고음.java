import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        answer = dfs(n, 0, 0);
        
        return answer;
    }
    
    int dfs(int n, int plusCnt, int mulCnt) {
        
        if(n<=0)
            return 0;
        
        if(n==1) {
            if(plusCnt%2!=0) return 0;
            if(plusCnt/2!=mulCnt) return 0;
            
            return 1;
        }
        
        // 가지치기 필요
        int needMul = plusCnt/2 - mulCnt;
        
        if((long)n < Math.pow(3L, (long)needMul))
            return 0;
        
        int result = dfs(n-1, plusCnt+1, mulCnt);
        
        if(n%3==0 && (plusCnt/2)>mulCnt)
            result += dfs(n/3, plusCnt, mulCnt+1);
        
        return result;
    }
}