import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(),"*");

        String front = st.nextToken();
        String back = st.nextToken();

        for(int i=0;i<N;i++){
            String str = br.readLine();

            if(str.length()<front.length() || str.length()<back.length() || str.length()<(front.length()+back.length()))
                System.out.println("NE");
            else if(str.substring(0, front.length()).equals(front) && str.substring(str.length()-back.length()).equals(back))
                System.out.println("DA");
            else
                System.out.println("NE");
            
        }
        
    }
}
