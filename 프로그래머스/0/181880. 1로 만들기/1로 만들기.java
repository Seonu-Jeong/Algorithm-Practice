class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        for(int x: num_list) {
            while(x!=1) {
                if(x%2==1)
                    x = (x-1)/2;
                else
                    x /= 2;
                answer++;
            }
        }
        return answer;
    }
}