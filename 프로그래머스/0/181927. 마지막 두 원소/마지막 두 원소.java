class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length+1];
        
        for(int i=0;i<num_list.length;i++)
            answer[i]=num_list[i];
        
        int n = num_list.length-1;
        
        answer[num_list.length] = num_list[n]>num_list[n-1]?num_list[n]-num_list[n-1]:2*num_list[n];
        
        return answer;
    }
}