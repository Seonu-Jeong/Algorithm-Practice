import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,C;
    
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());   
        C = Integer.parseInt(st.nextToken());

        TreeMap<Integer,int[]> map = new TreeMap<>();

        st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<N; i++){
            int key = Integer.parseInt(st.nextToken());
            int[] value = map.get(key);

            if(value!=null){
                value[1]++;
                map.put(key, value);
            }
            else
                map.put(key, new int[]{i,1});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b)->{
            if(a[2]==b[2])
                return a[1]-b[1];

            return b[2]-a[2];
        });


        for(Integer key : map.keySet()){
            int[] value = map.get(key);
            pq.add(new int[]{key, value[0], value[1]});
        }

        while(!pq.isEmpty()){
            int[] x = pq.poll();

            for(int i=0; i<x[2]; i++){
                System.out.print(x[0]+" ");
            }
        }
    }
}