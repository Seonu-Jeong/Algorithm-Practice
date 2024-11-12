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
	StringTokenizer st;
	
	int N,M;
	int[][] map;
	
	int maxValue=-1;
	
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
	    
	    
	    combi(-1, new ArrayDeque<Integer>());
	    
	    System.out.println(maxValue);
	}
	
	void combi(int start, ArrayDeque<Integer> arr){
	    
	    if(arr.size()==3){
	        if(!checkEmptySpace(arr))
	            return;
	        
	        int[][] newMap = copyMap();
	        
	        setWall(newMap, arr);
	        
	        spreadVirus(newMap);
	        
	        maxValue = Math.max(maxValue,
	            getSafeZoneSize(newMap));
	            
	        return;
	    }
	    
	    for(int i=start+1; i<(N*M); i++){
	        arr.push(i);
	        combi(i, arr);
	        arr.pop();
	    }
	}
	
	int getSize(boolean[][] visited, int[][] map, int y, int x){
	    visited[y][x] = true;
	    
	    int[] dy = new int[]{0,1,0,-1};
	    int[] dx = new int[]{1,0,-1,0};
	    
	    int result = 1;
	    
	    for(int i=0; i<4; i++){
	        int ny = y + dy[i];
	        int nx = x + dx[i];
	        
	        if(ny<0||ny>=N||nx<0||nx>=M)
	            continue;
	            
	        if(map[ny][nx]!=0||visited[ny][nx])
	            continue;
	        
	        result += getSize(visited, map, ny, nx);
	    }
	    
	    return result;
	}
	
	int getSafeZoneSize(int[][] map) {
	    
	    boolean[][] visited = new boolean[N][M];
	    
	    int result = 0;
	    
	    for(int i=0; i<N; i++){
	        for(int j=0; j<M; j++){
	            if(!visited[i][j] && map[i][j]==0)
	                result += getSize(visited, map, i, j);       
	        }
	    }
	    
	    return result;
	}
	
	void spread(boolean[][] visited, int[][] map, int y, int x){
	    
	    visited[y][x] = true;
	    
	    int[] dy = new int[]{0,1,0,-1};
	    int[] dx = new int[]{1,0,-1,0};
	    
	    for(int i=0; i<4; i++){
	        int ny = y + dy[i];
	        int nx = x + dx[i];
	        
	        if(ny<0||ny>=N||nx<0||nx>=M)
	            continue;
	            
	        if(map[ny][nx]!=0||visited[ny][nx])
	            continue;
	        
	        map[ny][nx]=2;
	        spread(visited, map, ny, nx);
	    }
	}
	
	void spreadVirus(int[][] map){
	    
	    boolean[][] visited = new boolean[N][M];
	    
	    for(int i=0; i<N; i++){
	        for(int j=0; j<M; j++){
	            if(!visited[i][j] && map[i][j]==2)
	                spread(visited, map, i, j);       
	        }
	    }
	}
	
	void setWall(int[][] map, ArrayDeque<Integer> arr){
	    var it = arr.iterator();
	    
	    while(it.hasNext()){
	        int[] pos = convertNumToPos(it.next());
	        int y=pos[0], x=pos[1];
	        
	        map[y][x] = 1;
	    }
	}
	
	int[][] copyMap(){
	    int[][] target = new int[N][M];
	    
	    for(int i=0; i<N; i++){
	        for(int j=0; j<M; j++){
	            target[i][j]=map[i][j];
	        }
	    }
	    
	    return target;
	}
	
	boolean checkEmptySpace(ArrayDeque<Integer> arr){
	    var it = arr.iterator();
	    
	    while(it.hasNext()){
	        int[] pos = convertNumToPos(it.next());
	        int y=pos[0], x=pos[1];
	        
	        if(map[y][x]!=0)
	            return false;
	    }
	    
	    return true;
	}
	
	int[] convertNumToPos(int num){
	    return new int[]{num/M, num%M};
	}
	
}