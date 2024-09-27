import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        String s = br.readLine();

        int[] count = new int[26];

        for(char c : s.toCharArray()){
            count[c-'a']++;
        }

        for(int i=0;i<26;i++){
            System.out.print(count[i]+" ");
        }
  }
}
