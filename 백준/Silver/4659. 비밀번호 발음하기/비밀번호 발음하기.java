import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws Exception {

        while(true){
            String str = br.readLine();

            if(str.equals("end"))
                break;

            if( !condi_1(str) || !condi_2(str) || !condi_3(str))
                System.out.printf("<%s> is not acceptable.%n",str);
            else
                System.out.printf("<%s> is acceptable.%n",str);
        }

    }

    static boolean condi_1(String str) {

        char[] alpha_arr = {'a', 'e', 'i', 'o', 'u'};
        
        for(char ch : str.toCharArray()){

            for(char alpha : alpha_arr)
                if(ch==alpha)
                    return true;
        }

        return false;
    }

    static boolean condi_2(String str) {
        
        StringBuilder sb = new StringBuilder("");

        char[] mo_arr = {'a', 'e', 'i', 'o', 'u'};
        
        for(char ch : str.toCharArray()){

            boolean isMo=false;
            
            for(char mo : mo_arr){
                if(mo==ch){
                    sb.append('m');
                    isMo = true;
                    break;
                }
            }

            if(isMo) continue;

            sb.append('j');
        }

        for(int i=2; i<sb.length(); i++){
            if(sb.charAt(i)==sb.charAt(i-1) && sb.charAt(i)==sb.charAt(i-2))
                return false;
        }

        return true;
    }

    static boolean condi_3(String str) {
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i)==str.charAt(i-1)){
                if(str.charAt(i)=='e' || str.charAt(i)=='o')
                    continue;
                else
                    return false;
            }
        }

        return true;
    }
}