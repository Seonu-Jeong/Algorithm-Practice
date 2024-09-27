import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ret=0;
        int sum=0;
        for(int i=0;i<N;i++){
            if(i<K)
                sum+=arr[i];
            else{
                sum = sum - arr[i-K] + arr[i];
                ret = Math.max(ret, sum);
            }
            
            if(i==K-1)
                ret = sum;
        }

        System.out.println(ret);
    }
}
