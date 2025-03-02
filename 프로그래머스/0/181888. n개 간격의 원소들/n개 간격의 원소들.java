import java.util.*;
class Solution {
    public int[] solution(int[] num_list, int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<num_list.length; i++) {
            if(i%n==0)
                answer.add(num_list[i]);
        }
        
        return answer.stream().mapToInt(a->a).toArray();
    }
}