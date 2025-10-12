import java.util.*;

class Solution {
        
    int[] dy = new int[]{0, 1, 0, -1};
    int[] dx = new int[]{1, 0, -1, 0};
    
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(answer[i], 0);
        
        int dir = 0;
        int num = 1;
        int y=0, x=0;
        while( (y>=0&&y<n&&x>=0&&x<n) && answer[y][x]==0) {
            answer[y][x] = num++;
                
            int ny = y+dy[dir], nx = x+dx[dir];
            
            if(ny<0 || ny==n || nx<0 || nx==n || answer[ny][nx]!=0) {
                dir=(dir+1)%4;
            }
            
            y+=dy[dir]; x+=dx[dir];
        }
        
        return answer;
    }
}