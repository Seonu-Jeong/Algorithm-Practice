import java.util.*;
class Solution {
    public int solution(int[] cookie) {
        int N = cookie.length;
        
        int[] sum = new int[N];
        Arrays.fill(sum,0);
        sum[0] = cookie[0];
        
        for(int i=1; i<N; i++)
            sum[i] = cookie[i] + sum[i-1]; 
        
        int result = 0;
        for(int i=0; i<N; i++) {
            
            for(int j=i+1; j<N; j++) {
                result = Math.max(result, getCookie(i,j,sum));
            }
        }
        
        return result;
    }
    
    int getCookie(int le, int ri, int[] sum) {
        
        int entire = sum[ri];
        if(le!=0)
            entire-=sum[le-1];
        
        int realLe = le;
        
        while(le<ri) {
            int mid = (le+ri)/2;
            int sumLe = sum[mid];
            
            if(realLe!=0)
                sumLe-=sum[realLe-1];
            
            if(entire-sumLe<sumLe){
                ri = mid; 
            }
            else if(entire-sumLe>sumLe) {
                le = mid+1;
            }
            else
                return sumLe;
        }
        
        return -1;
    }
}