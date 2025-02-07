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
		new Main().solution();
	}
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	StringTokenizer st;
	
	int V, E, K;
	
	ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
	
	void solution() throws Exception {
        
        st = new StringTokenizer(br.readLine());
        
        // 그래프 정보 초기화
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        
        // 인정 행렬 초기화
        for(int i=0; i<V+1; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            
            int u,v,w;
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            
            adj.get(u).add(new int[]{w,v});
        }
        
        // 다익스크라
        int[] dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        
        dist[K] = 0;
        pq.add(new int[]{0,K});
        
        while(!pq.isEmpty()) {
            
            int here = pq.peek()[1];
            int here_dist = pq.peek()[0];
            pq.poll();
            
            if(dist[here]!=here_dist) continue;
            
            for(int[] there : adj.get(here)) {
                int _there = there[1];
                int _dist = there[0];
                
                if(dist[_there]>dist[here]+_dist){
                    dist[_there] = dist[here]+_dist;
                    pq.add(new int[]{dist[_there], _there});
                }
            }
        }
        
        // 출력
        
        for(int i=1; i<=V; i++){
            if(dist[i]==Integer.MAX_VALUE){
                bw.write("INF");
                bw.newLine();
                continue;
            }
            bw.write(String.valueOf(dist[i]));
            bw.newLine();
        }
        
        bw.flush();
        
	}
	
	
	
}
