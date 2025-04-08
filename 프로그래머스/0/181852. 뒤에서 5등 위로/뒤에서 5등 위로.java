import java.util.*;
class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length-5];
        Arrays.sort(num_list);
        
        int len = num_list.length;
        for(int i=5,j=0; i<len; i++,j++)
            answer[j]=num_list[i];
        
        return answer;
    }
}