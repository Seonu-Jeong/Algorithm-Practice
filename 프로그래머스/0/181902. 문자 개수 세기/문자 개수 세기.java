class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        
        for(char ch : my_string.toCharArray()) {
            if(ch>='a'&&ch<='z')
                answer[ch-'a'+26]++;
            else
                answer[ch-'A']++;
        }
        return answer;
    }
}