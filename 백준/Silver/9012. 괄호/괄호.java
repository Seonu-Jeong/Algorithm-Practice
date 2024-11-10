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
        int tc = Integer.parseInt(br.readLine());
        
        while(tc!=0){
            tc--;
            
            String ps = br.readLine();
            
            int left_cnt=0;
            
            boolean isVPS = true;
            
            for(char ch : ps.toCharArray()) {
                if(ch=='(')
                    left_cnt++;
                else{
                    left_cnt--;        
                }
                
                if(left_cnt<0){
                    isVPS=false;
                    break;
                }
            }
            
            if(left_cnt!=0)
                isVPS=false;
                
                
            if(isVPS==true)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        
	   
	}
}