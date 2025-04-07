class Solution {
    public int solution(int[] common) {
        int answer = 0;
        
        int diff_sum = common[1]-common[0];
        boolean sumFlag = false;
        
        int diff_mul=-1;
        boolean mulFlag = true;
        if(common[0]!=0){
            diff_mul = common[1]/common[0];
        }
        
        
        for(int i=2; i<common.length; i++) {
            
            if(diff_sum != common[i]-common[i-1])
                sumFlag = true;
            
            if(common[i-1]!=0 && diff_mul != common[i]/common[i-1])
                mulFlag = true;
        }
        
        if(!sumFlag)
            answer = common[common.length-1]+diff_sum;
        else
            answer = common[common.length-1]*diff_mul;
        
        return answer;
    }
}