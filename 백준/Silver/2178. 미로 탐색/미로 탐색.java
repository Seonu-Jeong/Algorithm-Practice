import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] miro = new int[N][M];

        for(int i=0;i<N;i++){
            char[] chs = br.readLine().toCharArray();

            for(int j=0;j<chs.length;j++){
                miro[i][j]=chs[j]-'0';
            }
        }

        //

        int[] dy = {-1,0,1,0};
        int[] dx = {0,1,0,-1};

        boolean[][] visited = new boolean[N][M];
        
        
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.addLast(new int[]{0,0});

        int dist=1;

        outer:
        while(!que.isEmpty()){
            int size = que.size();
            
            while(size--!=0){
                int curY = que.peekFirst()[0];
                int curX = que.peekFirst()[1];
                que.pollFirst();

                if(curY==N-1 && curX==M-1){
                    break outer;      
                }
                
                for(int i=0;i<4;i++){
                    int newY = curY + dy[i];
                    int newX = curX + dx[i];

                    if(newY<0 || newY>=N || newX<0 || newX>=M || miro[newY][newX]==0 || visited[newY][newX]==true) continue;

                    que.addLast(new int[]{newY, newX});
                    visited[newY][newX] = true;
                }
            }

            dist++;
        }

        System.out.println(dist);
    }
}