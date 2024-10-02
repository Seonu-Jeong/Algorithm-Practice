import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int solution(int n) {
        long ret = 1;

        int size=1;
        
        while(ret%n!=0){
            ret=(ret*10+1)%n;
            size++;    
        }

        return size;
    }
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String input="";
        
        while((input=br.readLine())!=null && !input.isEmpty()){
            int n = Integer.parseInt(input);

            bw.write( String.valueOf(solution(n)) );
            bw.newLine();
        }

        bw.flush();
        
    }
}