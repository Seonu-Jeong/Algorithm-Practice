import java.util.*;
class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(String str: strArr) {
            Integer value = map.get(str.length());
            
            if(value==null){
                map.put(str.length(), 1);
                continue;
            }
            
            map.put(str.length(), value+1);
            answer = Math.max(answer, value+1);
        }
        
        return answer;
    }
}