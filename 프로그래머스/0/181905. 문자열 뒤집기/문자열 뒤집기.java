import java.util.*;
class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = "";
        StringBuilder subSb = new StringBuilder(my_string.substring(s,e+1)).reverse();
        StringBuilder sb = new StringBuilder(my_string);
        
        sb = sb.replace(s,e+1, subSb.toString());
        
        return sb.toString();
    }
}