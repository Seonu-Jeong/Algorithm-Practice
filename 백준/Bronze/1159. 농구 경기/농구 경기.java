import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] cnt = new int[26];
        
        for(int i=0;i<N;i++){
            String name = br.readLine();

            cnt[name.charAt(0)-'a']++;
        }

        boolean isLose = true;
        
        for(int i=0;i<26;i++){
            if(cnt[i]>=5){
                isLose=false;
                System.out.print((char)('a'+i));
            }
        }

        if(isLose)
            System.out.println("PREDAJA");
    }
}
