import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static long calc(long a, long b, long c){

        if(b==1)
            return a%c;
        
        if(b%2==1)
            return ( a * calc(a, b-1, c) ) % c;
        
        long ret = calc(a, b/2, c)%c;

        return (ret*ret)%c;
    }
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        long A=sc.nextLong(), B=sc.nextLong(), C=sc.nextLong();

        long ret = calc(A,B,C);
        
        System.out.println(ret);
    }
}