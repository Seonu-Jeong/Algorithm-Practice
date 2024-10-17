import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int M,N,K;
    static int[][] map;
    static boolean[][] visited;
    
    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};
    
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());    
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];
        
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());

            // x1,y1, x2, y2
            int[] pos = new int[4];
            
            for(int j=0;j<4;j++){
                pos[j] = Integer.parseInt(st.nextToken());
            }

            fillMap(map,pos);
        } 


        int cnt=0;
        List<Integer> ret = new ArrayList<>();
        for(int y=0; y<M; y++){
            
            for(int x=0; x<N; x++){
                
                if(map[y][x]==0 && !visited[y][x]){
                    cnt++;
                    ret.add(dfs(y,x));
                }
            }
        }

        System.out.println(cnt);
        Collections.sort(ret);

        for(Integer x : ret){
            System.out.print(x + " ");
        }
    }

    static void fillMap(int[][] map, int[] pos){

        for(int y=pos[1]; y<pos[3]; y++){
            for(int x=pos[0]; x<pos[2]; x++){
                map[y][x]=1;
            }
        }
    }

    static int dfs(int y, int x){
        visited[y][x]=true;

        int size=1;
        
        for(int i=0;i<4;i++){
            int ny = dy[i] + y;
            int nx = dx[i] + x;

            if(ny<0 || ny>=M || nx<0 || nx>=N || visited[ny][nx] || map[ny][nx]==1) continue;

            size += dfs(ny,nx);    
        }

        return size;
    }
}