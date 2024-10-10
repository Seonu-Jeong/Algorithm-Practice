import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T--!=0){
            solution(br);
        }
    }

    static int N;
    static int M;
    static boolean[][] visited;
    static int[][] map;
    
    static void solution(BufferedReader br) throws Exception {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[y][x] = 1;
        }


        visited = new boolean[N][M];
        int ret = 0;
        for(int y=0;y<N;y++){
            for(int x=0;x<M;x++){
                if(map[y][x]==1 && visited[y][x]==false){
                    dfs(y,x);
                    ret++;
                }
            }
        }

        System.out.println(ret);
        
    }
    
    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};
    
    static void dfs(int y, int x){
        visited[y][x]=true;

        for(int i=0;i<4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny<0 || ny>=N || nx<0 || nx>=M || visited[ny][nx] || map[ny][nx]==0)
                continue;

            dfs(ny,nx);
        }    
    }
}