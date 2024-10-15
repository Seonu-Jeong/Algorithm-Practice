class Solution {
    public String solution(int[] food) {
        
        for(int i=1; i<food.length; i++){
            food[i]/=2;
        }
        
        StringBuilder str = new StringBuilder("");
        
        for(int i=1; i<food.length; i++){
            
            for(int j=0; j<food[i]; j++){
                str.append(i);
            }
        }
        
        StringBuilder answer = new StringBuilder(str);
        answer.append(0);
        answer.append(str.reverse());
        
        return answer.toString();
    }
}