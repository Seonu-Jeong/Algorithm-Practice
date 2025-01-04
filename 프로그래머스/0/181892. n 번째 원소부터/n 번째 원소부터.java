class Solution {
    public int[] solution(int[] num_list, int n) {
        int len = num_list.length;
        
        int[] answer = new int[len-n+1];
        
        for(int i=n-1,j=0; i<len; i++,j++){
            answer[j]=num_list[i];
        }
        return answer;
    }
}