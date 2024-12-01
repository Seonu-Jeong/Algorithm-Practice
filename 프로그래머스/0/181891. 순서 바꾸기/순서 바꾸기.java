class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];
        
        int cnt=0;
        while(cnt!=num_list.length){
            
            n = (n)%num_list.length;
            answer[cnt]=num_list[n];
            
            n = (n+1)%num_list.length;
            cnt++;
        }
        
        return answer;
    }
}