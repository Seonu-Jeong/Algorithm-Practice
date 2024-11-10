/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
import java.io.*;


public class Main
{
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
	public static void main(String[] args) throws Exception {
	    int N = Integer.parseInt(br.readLine());
	    
	    int cnt=1;
	    
	    int num=666;
	    
	    while(cnt!=N){
	        num++;
	        
	        String num_str = String.valueOf(num);
	        
	        if(num_str.indexOf("666")!=-1)
	            cnt++;
	    }
	    
	    System.out.println(num);
	}
}