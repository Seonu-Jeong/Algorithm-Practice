import java.util.*;

class Solution {
    public int solution(int[] money) {
        int n = money.length;
        
        int[] dpF = new int[n]; // 첫집부터
        int[] dpS = new int[n]; // 두째부터
        
        dpF[0] = money[0];
        
        dpF[1] = Math.max(money[1], dpF[0]);
        dpS[1] = money[1];
            
        // 초기화 end
        
        int result = 0;
        
        for(int i=2; i<n; i++) {
            if(i<n-1){
                dpF[i] = Math.max(dpF[i-2]+money[i], dpF[i-1]);
            }
            
            dpS[i] = Math.max(dpS[i-2]+money[i], dpS[i-1]);
            
            if(i<n-1)
                result = Math.max(result, Math.max(dpF[i],dpS[i]));
            
            result = Math.max(result, dpS[i]);
        }
        
        return result;
    }
    
}