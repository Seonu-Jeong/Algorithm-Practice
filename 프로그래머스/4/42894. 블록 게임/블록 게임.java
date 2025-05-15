import java.util.*;
class Solution {
    
    int N;
    int[][] board;

    public int solution(int[][] board) {
        N = board.length;
        this.board = board;
        
        int total=0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(board[i][j]==0) continue;

                
                total+=func(i,j);
            }
            
            for(int j=N-1; j>=0; j--) {
                if(board[i][j]==0) continue;
                
                total+=func(i,j);
            }
        }
        
        
        
        return total;
    }
    
    int func(int r, int c) {
        
        ArrayDeque<int[]> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        
        que.add(new int[]{r,c});
        visited[r][c]=true;
        
        Set<int[]> set = new TreeSet<>((a,b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            return a[1]-b[1];
        });
        set.add(new int[]{r,c});
        
        int[] xRange = new int[]{c,c};        
        int[] yRange = new int[]{r,r};
        
        int[] dy = new int[]{0,1,0,-1};
        int[] dx = new int[]{1,0,-1,0};
        
        while(!que.isEmpty()) {
            int[] frt = que.poll();
            int y = frt[0], x = frt[1];
            
            for(int i=0; i<4; i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                
                if(ny<0||ny>=N||nx<0||nx>=N||board[ny][nx]!=board[r][c])
                    continue;
                
                if(visited[ny][nx]) continue;
                
                visited[ny][nx]=true;
                set.add(new int[]{ny,nx});
                que.add(new int[]{ny,nx});
                
                setRange(xRange,nx);
                setRange(yRange,ny);
            }
        }
        
        // System.out.printf("set size:%d\n",set.size());
        // System.out.printf("xRange: %d, %d\n",xRange[0], xRange[1]);
        // System.out.printf("yRange: %d, %d\n",yRange[0], yRange[1]);
        // 검은 블럭 위치 찾기
        int yfor = 3;
        int xfor = 2;
        
        if(xRange[1]-xRange[0]>yRange[1]-yRange[0]){
            int tmp = yfor;
            yfor = xfor;
            xfor = tmp;
        }
        
        int leUpY = yRange[0];
        int leUpX = xRange[0];
        
        int cnt=0;
        
        for(int i=0; i<yfor; i++) {
            for(int j=0;j<xfor; j++) {
                int ny = leUpY+i;
                int nx = leUpX+j;
                
                //System.out.printf("ny:%d nx:%d\n",ny,nx);
                if(set.contains(new int[]{ny,nx}))
                    continue;
                
                //검은블럭 가능 판별
                //System.out.println("CHECK BLACK");
                if(isPossible(ny,nx)) 
                    cnt++;
            }
        }
        
        if(cnt==2){
            for(int[] arr : set) {
                board[arr[0]][arr[1]]=0;
            }
            //System.out.println("IS DELETE");
            return 1;
        }
        
        return 0;
    }
    
    boolean isPossible(int y, int x){
        
        for(int i=y; i>=0; i--){
            if(board[i][x]!=0)
                return false;
        }
        
        return true;
    }
    
    void setRange(int[] range, int a) {
        
        if(range[0]>a)
            range[0]=a;
        
        if(range[1]<a)
            range[1]=a;
    }
}