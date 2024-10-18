class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        int total=0;
        int cx = x;
        
        while(cx!=0){
            total += cx%10;
            cx /= 10;
        }
        
        return x%total==0?true:false;
    }
}