import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int apple_size;
    
    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        apple_size = Integer.parseInt(br.readLine());
        
        int le=1;
        int ri=le+M-1;

        int result=0;
        
        for(int i=0; i<apple_size; i++){
            int pos = Integer.parseInt(br.readLine());

            int move=0;
            
            if(le<=pos && ri>=pos)
                continue;
            else if(le>pos){
                move=pos-le;    
            }
            else
                move=pos-ri;
            
            result += Math.abs(move);

            le+=move; ri+=move;

        }

        System.out.println(result);
    }
}