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
    
    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in)
    );
    
    BufferedWriter bw = new BufferedWriter(
        new OutputStreamWriter(System.out)
    );
    
    StringTokenizer st;
	
	int N, M;
	List<Integer> adj[];
	
	void solution() throws Exception {
	    
	    initValue();
	    
	    int[] cntArr = new int[N+1];
	    
	    int maxValue = 0;
	    
	    for(int i=1; i<=N; i++) {
	        cntArr[i] = dfs(i, new boolean[N+1]);
	        
	        maxValue = Math.max(cntArr[i], maxValue);
	    }
	    
	    for(int i=1; i<=N; i++) {
	        if(cntArr[i] == maxValue)
	            bw.write(i+" ");
	            
	    }
	    
	    bw.flush();
	    
	}
	
	int dfs(int cur, boolean[] visited) {
	    visited[cur] = true;
	    
	    int cnt = 1;
	    
	    for(int child : adj[cur]) {
	        
	        if(visited[child]==true)
	            continue;
	            
	        cnt += dfs(child, visited);
	    }
	    
	    return cnt;
	}
	
	void initValue() throws Exception {
	    
	    st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    adj = new ArrayList[N+1];
	    
	    for(int i=1; i<N+1; i++)
	        adj[i] = new ArrayList<>();
	        
	    for(int i=0; i<M; i++) {
	        st = new StringTokenizer(br.readLine());
	        
	        int A = Integer.parseInt(st.nextToken())
	        , B = Integer.parseInt(st.nextToken());
	        
	        adj[B].add(A);
	    }
	}
}