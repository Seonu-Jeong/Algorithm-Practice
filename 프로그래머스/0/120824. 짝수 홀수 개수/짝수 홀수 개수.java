class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = {0,0};
        for(int x: num_list) {
            if(x%2==0)
                answer[0]++;
            else
                answer[1]++;
        }
        return answer;
    }
}