/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		new Main().solution();
	}
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	
	int N,M;
	int[][] map;
	
	void solution() throws Exception {
	    
	    st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    map = new int[N][M];
	    
	    for(int i=0; i<N; i++){
	        
	        st = new StringTokenizer(br.readLine());
	        
	        for(int j=0; j<M; j++){
	            map[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    int time = 0;
	    int cheeseSize = 0;
	    
	    while(isExistCheese()){
	        
	        cheeseSize = countCheese();
	        
	        time++;
	        
	        boolean[][] checkedCheese = checkRemoveCheese();
	        
	        removeCheese(checkedCheese);
	    }
	    
	    System.out.println(time);
	    System.out.println(cheeseSize);
	    
	}
	
	void removeCheese(boolean[][] checkedCheese){
	    
	    for(int i=0; i<N; i++){
	        for(int j=0; j<M; j++){
	            if(checkedCheese[i][j])
	                map[i][j]=0;
	        }
	    }
	}
	
	boolean[][] checkRemoveCheese() {
	    
	    boolean[][] checkMap = new boolean[N][M];
	    
	    ArrayDeque<int[]> que = new ArrayDeque<>();
	    
	    boolean[][] visited = new boolean[N][M];
	    
	    que.addLast(new int[]{0,0});
	    visited[0][0] = true;
	    
	    int[] dy = new int[]{0,1,0,-1};
	    int[] dx = new int[]{1,0,-1,0};
	    
	    while(!que.isEmpty()){
	        
	        int queSize = que.size();
	        
	        while(queSize!=0){
	            queSize--;
	            
	            int[] pos = que.removeFirst();
	            
	            int y=pos[0], x=pos[1];
	            
	            for(int i=0; i<4; i++){
	                
	                int ny = y + dy[i];
	                int nx = x + dx[i];
	                
	                if(ny<0||ny>=N||nx<0||nx>=M||visited[ny][nx])
	                    continue;
	                   
	                   
                    visited[ny][nx] = true;
                    
	                if(map[ny][nx]==1)
	                    checkMap[ny][nx]=true;
	                else 
	                    que.addLast(new int[]{ny,nx});
	            }
	            
	        }
	    }
	    
	    return checkMap;
	    
	}
	
	int countCheese(){
	    
	    int cheese=0;
	    
	    for(int i=0; i<N; i++){
	        for(int j=0; j<M; j++){
	            if(map[i][j]==1)
	                cheese++;
	        }
	    }
	    
	    return cheese;
	}
	
	boolean isExistCheese(){
	    
	    for(int i=0; i<N; i++){
	        for(int j=0; j<M; j++){
	            if(map[i][j]==1)
	                return true;
	        }
	    }
	    
	    return false;
	}
}