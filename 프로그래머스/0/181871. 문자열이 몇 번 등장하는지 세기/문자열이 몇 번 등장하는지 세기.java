class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int from = 0;
        while(true) {
            int result = myString.indexOf(pat,from);
            if(result==-1)
                break;
            from = result+1;
            answer++;
        }
        
        return answer;
    }
}