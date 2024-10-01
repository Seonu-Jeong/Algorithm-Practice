import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b)->{
            if(a[0]==b[0])
                return a[1]-b[1];

            return a[0]-b[0];
        });

        int le=0;
        int[] d_arr = new int[N];
        for(int ri=0;ri<N;ri++){
            pq.add(new int[]{arr[ri],ri});

            int len = ri-le+1;

            if(len>L)
                le++;

            while(pq.peek()[1]<le){
                pq.poll();
            }

            d_arr[ri]=pq.peek()[0];
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        for(int x: d_arr){
            bw.write(String.valueOf(x)+" ");
        }

        bw.flush();
    }
}