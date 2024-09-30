import java.util.*;

class Solution {
    
    
    void make_danger_zone(int[][] map, int r, int c, int n){
        int dx[] = {-1,0,1,1,1,0,-1,-1};
        int dy[] = {-1,-1,-1,0,1,1,1,0};

        for(int i=0;i<8;i++){
            int nr = r+dx[i];
            int nc = c+dy[i];
            
            if(nr<0||nr>=n||nc<0||nc>=n||map[nr][nc]==1) continue;
            
            map[nr][nc]=-1;
        }
        
    }
    
    public int solution(int[][] board) {
        int n = board.length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1)
                    make_danger_zone(board, i, j, n);
            }
        }
        
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]!=1&&board[i][j]!=-1)
                    cnt++;
            }
        }
        
        return cnt;
    }
}