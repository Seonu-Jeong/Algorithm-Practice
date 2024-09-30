import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> dict = new TreeMap<>();
        
        for(int i=0;i<N;i++){
            dict.put(arr[i],i);
        }

        int cnt=0;

        for(int i=0;i<N;i++){
            int diff = M-arr[i];
            
            Integer cur = dict.get(arr[i]);
            Integer old = dict.get(diff);
            
            if(old==null || old==-1 || cur==-1 || old==cur) continue;

            cnt++;

            dict.replace(diff, -1);
            dict.replace(arr[i], -1);
        }

        System.out.println(cnt);
    }
}