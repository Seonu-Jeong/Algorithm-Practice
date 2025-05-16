class Solution {
    
    int[] dy = new int[]{0,1,0,-1};
    int[] dx = new int[]{1,0,-1,0};
    
    int n;
    int MAX = 100_000_000;
    public int solution(int[][] clockHands) {
        n = clockHands.length;
        
        return dfs(0, clockHands);
    }
    
    int dfs(int idx, int[][] clockHands) {
        
        if(idx==n*n){
            //System.out.println("END");
            if(check(clockHands)) {
                //System.out.println("OK");
                return 0;
            }
            return MAX;
        }
        
        int r = idx/n;
        int c = idx%n;
        
        int result = MAX;
        
        for(int k=0; k<4; k++) {
            
            if(r-1>=0)
                if((clockHands[r-1][c]+k)%4!=0)
                    continue;
            
            roll(r, c, clockHands, k);
            
            result = Math.min(result, dfs(idx+1, clockHands)+k);
            
            roll(r, c, clockHands, 4-k);
        }
        
        return result;
    }
    
    boolean check(int[][] clockHands) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++){
                if(clockHands[i][j]!=0)
                    return false;
            }
        }
        return true;
    }
    
    void roll(int r, int c, int[][] clockHands, int v) {
        
        clockHands[r][c] = (clockHands[r][c]+v)%4;
        
        for(int i=0; i<4; i++) {
            int ny = r+dy[i];
            int nx = c+dx[i];
            
            if(ny<0||ny>=n||nx<0||nx>=n) continue;
            
            clockHands[ny][nx] = (clockHands[ny][nx]+v)%4;
        }
    }
}