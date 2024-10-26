class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int sum=0;
        int mul=1;
        
        for(int x : num_list){
            sum+=x;
            mul*=x;
        }
        
        if(mul<sum*sum)
            answer=1;
        
        return answer;
    }
}