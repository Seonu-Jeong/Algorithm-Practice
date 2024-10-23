/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int H = Integer.parseInt(st.nextToken());
	    int W = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[H][W];
		int[][] ret = new int[H][W];
		
		for(int i=0; i<H; i++){
		    map[i]=br.readLine().toCharArray();
		}
		
		for(int i=0; i<H; i++){
		    
		    int recent=-1;
		    for(int j=0; j<W; j++){
		        if(map[i][j]=='c')
		            recent=0;
		        
		        ret[i][j]=recent;
		        
		        recent = recent!=-1?recent+1:recent;
		    }
		}
		
		for(int i=0; i<H; i++){
		    for(int j=0; j<W; j++){
		        System.out.print(ret[i][j]+" ");
		    }
		    System.out.println("");
		}
	}
}