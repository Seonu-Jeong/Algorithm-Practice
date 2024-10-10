import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int N;
    static int[][] map;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static boolean[][] visited;
    
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for(int y=0;y<N;y++){
            st = new StringTokenizer(br.readLine());
            
            for(int x=0;x<N;x++){
                map[y][x] = Integer.parseInt(st.nextToken());    
            }
        }

        
        int ret=0;

        for(int water=0;water<=100;water++){
            
            int cnt=0;
            visited = new boolean[N][N];
            
            for(int y=0;y<N;y++){
                for(int x=0;x<N;x++){
                    if(map[y][x]>water && !visited[y][x]){
                        dfs(y,x,water);
                        cnt++;
                    }
                }
            }

            ret = Math.max(ret, cnt);

            if(cnt==0) break;
        }

        System.out.println(ret);
            
    }

    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};
    
    static void dfs(int y,int x, int water){
        visited[y][x]=true;

        for(int i=0;i<4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(nx<0 || nx>=N || ny<0 || ny>=N || visited[ny][nx] || map[ny][nx]<=water) continue;

            dfs(ny,nx,water);
        }
    }

    
}