import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for(char ch : arr){
            if( ch>='a'&&ch<='z' ){
                ch += 13;
                ch -= 'a';
                ch %= 26;
                ch += 'a';
            }
            else if( ch>='A'&&ch<='Z'){
                ch += 13;
                ch -= 'A';
                ch %= 26;
                ch += 'A';
            }

            sb.append(ch);
        }

        System.out.println(sb.toString());
        
    }
}
