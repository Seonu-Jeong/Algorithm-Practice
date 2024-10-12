import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int x=0;x<commands.length;x++){
            int i=commands[x][0], j=commands[x][1], k=commands[x][2];
            
            int[] narr =  Arrays.copyOf(array, array.length);
            
            Arrays.sort(narr,i-1,j);
            
            answer[x]=narr[i+k-2];
        }
        
        return answer;
    }
}