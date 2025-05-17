import java.util.*;
class Solution {
    
    Map<Integer, List<Set<int[]>>> empty_map = new TreeMap<>();
    
    int n;
    boolean[][] visited;
    
    int[] dy = new int[]{0,1,0,-1};
    int[] dx = new int[]{1,0,-1,0};
    
    int[][] game_board;
    int[][] table;
    
    public int solution(int[][] game_board, int[][] table) {
    
        this.game_board = game_board;
        this.table = table;
        n = game_board.length;
        
        visited = new boolean[n][n];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(visited[i][j]) continue;
                if(game_board[i][j]==1) continue;
                
                Set<int[]> set = new TreeSet<>((a,b)->{
                    if(a[0]!=b[0]) return a[0]-b[0];
                    return a[1]-b[1];
                });
                
                dfsBoard(i, j, set, i, j);
                
                if(empty_map.get(set.size())==null)
                    empty_map.put(set.size(), new LinkedList<>());
                
                empty_map.get(set.size()).add(set);
            }
        }
        
        int total=0;
        
        for(int k=0; k<4; k++) {
            
            int[][] rotated = rotate();
            this.table = rotated;
            
            visited = new boolean[n][n];
            
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(visited[i][j]) continue;
                    if(this.table[i][j]==0) continue;

                    ArrayList<int[]> set = new ArrayList<>();
                    dfsTable(i, j, set, i, j);

                    int idx=0;
                    boolean isMatch=false;
                    List<Set<int[]>> emptys = empty_map.get(set.size());
                    
                    if(emptys==null)
                        continue;
                    
                    for(Set<int[]> empty : emptys) {
                        
                        if(match(empty, set)){
                            empty_map.get(set.size()).remove(idx);
                            isMatch=true;
                            break;
                        }

                        idx++;
                    }

                    if(isMatch) {
                        total+=set.size();
                        
                        delete(i, j, set);    
                    }
                    
                    // System.out.printf("i:%d j:%d\n", i, j);
                    // System.out.println(total);
                }
            }
        }
        
        return total;
        
    }
    
    void delete(int i, int j, ArrayList<int[]> set) {
        
        for(int[] a: set) {
            table[a[0]+i][a[1]+j]=0;
        }
    }
    
    int[][] rotate() {
        
        int[][] result = new int[n][n];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                result[j][n-1-i] = table[i][j];
            }
        }
        
        return result;
    }
    
    void dfsTable(int y, int x, List<int[]> set, int r, int c) {
    
        visited[y][x] = true;
        set.add(new int[]{y-r, x-c});
        
        for(int i=0; i<4; i++) {
            int ny = y+dy[i];
            int nx = x+dx[i];
            
            if(ny<0||ny>=n||nx<0||nx>=n) continue;
            if(table[ny][nx]==0) continue;
            if(visited[ny][nx]) continue;
            
            dfsTable(ny, nx, set, r, c);
        }
    }
    
    void dfsBoard(int y, int x, Set<int[]> set, int r, int c) {
    
        visited[y][x] = true;
        set.add(new int[]{y-r, x-c});
        
        for(int i=0; i<4; i++) {
            int ny = y+dy[i];
            int nx = x+dx[i];
            
            if(ny<0||ny>=n||nx<0||nx>=n) continue;
            if(game_board[ny][nx]==1) continue;
            if(visited[ny][nx]) continue;
            
            dfsBoard(ny, nx, set, r, c);
        }
    }
    
    
    boolean match(Set<int[]> empty_space, ArrayList<int[]> arr) {
            
      
         
        for(int[] a: arr) {

            boolean isMatch=true;

            for(int[] b: reset(a, arr)) {
                if(!empty_space.contains(b)) {
                    isMatch=false;
                    break;
                }
            }

            if(isMatch)
                return true;
        }
            
        
        
        return false;
    }
    
    ArrayList<int[]> reset(int[] std, ArrayList<int[]>  arr) {
        
        ArrayList<int[]> result = new ArrayList<>();
        
        for(int[] a : arr) {
            result.add(new int[]{a[0]-std[0], a[1]-std[1]});
        }
        
        return result;
    }
}