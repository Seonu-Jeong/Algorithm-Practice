import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int[] cost = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<3;i++)
            cost[i]=Integer.parseInt(st.nextToken());

        int[] cnt = new int[101];

        int start,end;
        for(int i=0;i<3;i++){
            st = new StringTokenizer(br.readLine());
            start=Integer.parseInt(st.nextToken());
            end=Integer.parseInt(st.nextToken());

            for(int j=start;j<end;j++){
                cnt[j]++;
            }
        }

        int total=0;
        for(int x : cnt){
            if(x==1)
                total += cost[0];
            else if(x==2)
                total += cost[1]*2;
            else if(x==3)
                total += cost[2]*3;
        }

        System.out.println(total);
    }
}
