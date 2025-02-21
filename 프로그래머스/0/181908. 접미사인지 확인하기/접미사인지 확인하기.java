class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer = 0;
        
        if(my_string.length()<is_suffix.length())
            return 0;
        
        int startIdx = my_string.length()-is_suffix.length();
        if(my_string.substring(startIdx).equals(is_suffix))
            answer = 1;
            
        return answer;
    }
}