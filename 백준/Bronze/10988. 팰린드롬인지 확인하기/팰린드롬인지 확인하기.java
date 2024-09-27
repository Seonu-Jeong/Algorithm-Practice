import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] word = br.readLine().toCharArray();

        int le=0,ri=word.length-1;

        while(true){
            if(word[le]!=word[ri]){
                System.out.println(0);
                return;
            }

            le++; ri--;

            if(le>ri)
                break;
        }

        System.out.println(1);
    }
}
