class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = "";
        
        String s = my_string;
        
        for(int[] query : queries) {
            s = func(s, query[0], query[1]);
        }
        
        return s;
    }
    
    String func(String str, int s, int e) {
        StringBuilder sb = new StringBuilder(str);
        
        StringBuilder reversedSb = new StringBuilder(sb.substring(s,e+1)).reverse();
        
        return sb.replace(s, e+1, reversedSb.toString()).toString(); 
    }
}