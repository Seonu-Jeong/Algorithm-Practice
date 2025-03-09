class Solution {
    public String solution(String myString) {
        StringBuilder answer = new StringBuilder();
        
        for(int i=0; i<myString.length(); i++) {
            char ch = myString.charAt(i);
            
            if(ch>='a'&&ch<='z')
                answer.append((char)(ch-'a'+'A'));
            else
                answer.append(ch);
        }
        
        return answer.toString();
    }
}