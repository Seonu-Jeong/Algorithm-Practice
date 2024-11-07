import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> answer = new ArrayList<>();
        
        for(int i=l; i<=r; i++){
            if(isOk(i))
                answer.add(i);
        }
        
        Collections.sort(answer);
        
        if(answer.isEmpty())
            answer.add(-1);
        
        return answer.stream().mapToInt(i->i).toArray();
    }
    
    boolean isOk(int num){
        String str = String.valueOf(num);
        
        for(char ch : str.toCharArray()){
            if(ch!='0' && ch!='5')
                return false;
        }
        
        return true;
    }
}