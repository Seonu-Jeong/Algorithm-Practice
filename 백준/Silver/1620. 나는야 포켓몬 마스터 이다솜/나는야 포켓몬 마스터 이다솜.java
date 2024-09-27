import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken()), M=Integer.parseInt(st.nextToken());

        HashMap<String,Integer> pocket_map = new HashMap<>();
        String[] pocket_arr = new String[N+1];

        for(int i=1;i<=N;i++){
            pocket_arr[i]=br.readLine();

            pocket_map.put(pocket_arr[i],i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<M;i++){
            String key = br.readLine();
            Integer value = pocket_map.get(key);
            if(value==null)
                bw.write(pocket_arr[Integer.parseInt(key)]);
            else
                bw.write(String.valueOf(value));

            bw.newLine();
        }

        bw.flush();
    }
}
