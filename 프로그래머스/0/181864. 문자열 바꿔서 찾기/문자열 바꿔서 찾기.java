class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder("");
        
        for(char ch : myString.toCharArray()) {
            if(ch=='A')
                sb.append((char)(ch+1));
            else
                sb.append((char)(ch-1));
        }
        
        if(sb.indexOf(pat)!=-1)
            answer = 1;
        
        
        return answer;
    }
}