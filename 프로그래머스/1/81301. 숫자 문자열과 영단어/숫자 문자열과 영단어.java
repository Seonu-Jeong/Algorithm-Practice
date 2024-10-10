import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
    
        String[] words = {
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine"
        };
        
        char[] cstr = s.toCharArray();
        
        int le=0, ri=0;
        int ret=0;
        for( ;ri<cstr.length;ri++){
            
            if(cstr[ri]>='0' && cstr[ri]<='9'){
                ret*=10;
                ret += (cstr[ri]-'0');
                le=ri+1;
                continue;
            } 
            
            
            String sub = s.substring(le,ri+1);
            
            for(int i=0;i<words.length;i++){
                if(sub.equals(words[i])){
                    ret*=10;
                    ret += i;
                    le=ri+1;
                    break;
                }
            }
       }
        
        return ret;
    }
}