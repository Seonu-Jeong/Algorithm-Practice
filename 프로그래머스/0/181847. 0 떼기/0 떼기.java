class Solution {
    public String solution(String n_str) {
        StringBuilder answer = new StringBuilder("");
        
        boolean leftZeroFlag = true;
        
        for(char ch : n_str.toCharArray()) {
            
            if(ch!='0'){
                leftZeroFlag = false;
            }
            
            if(leftZeroFlag)
                continue;
            
            answer.append(ch);
        }
        
        return answer.toString();
    }
}