/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
import java.io.*;

public class Main
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    int N;
	ArrayList<Integer>[] adj;
	int root;
	
	public static void main(String[] args) throws Exception {
		new Main().solution();

	}
	

	void solution() throws Exception {
        N = Integer.parseInt(br.readLine());
        
        adj = new ArrayList[N];
        
        for(int i=0; i<N; i++)
            adj[i] = new ArrayList<Integer>();
           
        st = new StringTokenizer(br.readLine());    
        
        for(int i=0; i<N; i++){
          int parent = Integer.parseInt(st.nextToken());
           
          if(parent == -1){
              root = i;
              continue;
          }
           
          adj[parent].add(i);
        }
        
        int removeNum = Integer.parseInt(br.readLine());
        
        boolean[] checkRemove = removeNode(removeNum);
        
        int result = countLeap(checkRemove);
        
        System.out.println(result); 
	}
	
	int countLeap(boolean[] checkRemove) {
	    
	    boolean[] visited = new boolean[N];
        
        ArrayDeque<Integer> que = new ArrayDeque<>();
        
        visited[root]  = true;
        
        que.addLast(root);
        
        int result = 0;
        
        while(!que.isEmpty()) {
        
            int cur = que.removeFirst();
            
            if(checkRemove[cur]==true)
                continue;
            
            int childCnt = 0;
            
            for( int child : adj[cur]) {
                
                if(visited[child]==true||checkRemove[child]==true)
                    continue;
                    
                visited[child] = true;
                
                que.addLast(child);
                
                childCnt++;
            }
            
            if(childCnt == 0)
                result++;
                
            //System.out.printf("%d : %d%n", cur, childCnt);
        }
        
        return result;
        
	}
	
	boolean[] removeNode(int removeNum) {
        
        boolean[] checkRemove = new boolean[N];
        
        boolean[] visited = new boolean[N];
        
        ArrayDeque<Integer> que = new ArrayDeque<>();
        
        visited[removeNum]  = true;
        
        checkRemove[removeNum] = true;
        
        que.addLast(removeNum);
        
        while(!que.isEmpty()) {
        
            int cur = que.removeFirst();
            
            for( int child : adj[cur]) {
                
                if(visited[child] == true) continue;
                
                visited[child] = true;
                
                checkRemove[child] = true;
                
                que.addLast(child);
            }
        
        }
        
        return checkRemove;
	   
	}
	
}