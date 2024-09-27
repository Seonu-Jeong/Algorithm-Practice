import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int[] height = new int[9];
    int sum=0;
    for(int i=0;i<9;i++){
        height[i] = Integer.parseInt(br.readLine());
        sum += height[i];
    }
    
    Arrays.sort(height);
    
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    outer:
    for(int i=0;i<9;i++){
        for(int j=i+1;j<9;j++){
            if(sum-(height[i]+height[j])==100){
                for(int k=0;k<9;k++){
                    if(k==i||k==j) continue;
                    
                    bw.write(String.valueOf(height[k]));
                    bw.newLine();
                }
                
                break outer;
            }
        }
    }

    bw.flush();
    
  }
}
