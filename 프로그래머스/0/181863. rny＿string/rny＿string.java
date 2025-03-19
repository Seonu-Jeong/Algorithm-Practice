class Solution {
    public String solution(String rny_string) {
        StringBuilder answer = new StringBuilder("");
        
        for(int i=0; i<rny_string.length(); i++) {
            char ch = rny_string.charAt(i);
            
            if(ch == 'm')
                answer.append("rn");
            else
                answer.append(ch);
        }
        
        return answer.toString();
    }
}