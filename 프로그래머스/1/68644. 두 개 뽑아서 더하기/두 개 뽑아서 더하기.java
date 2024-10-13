import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> s = new TreeSet<>();
        
        for(int i=0;i<numbers.length;i++){
            
            for(int j=i;j<numbers.length;j++){
                if(i==j) continue;
                
                s.add(numbers[i]+numbers[j]);
            }
        }
        
        int[] ret = new int[s.size()];
        int i=0;
        for(var it=s.iterator();it.hasNext();i++){
            ret[i]=it.next();
        }
        
        return ret;
    }
}