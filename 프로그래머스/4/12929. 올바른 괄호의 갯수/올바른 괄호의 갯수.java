class Solution {
    public int solution(int n) {
        int answer = func(n,n,0);
        return answer;
    }
    
    int func(int le, int ri, int cur) {
        
        if(le<0 || ri<0)
            return 0;
        
        if(le==0&&ri==0&&cur==0)
            return 1;
        
        int result=0;
        
        result+=func(le-1,ri,cur+1);
        
        if(cur>0){
            result+=func(le,ri-1,cur-1);
        }
        
        return result;
    }
}