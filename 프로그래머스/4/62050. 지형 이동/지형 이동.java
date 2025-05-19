import java.util.*;

class Solution {

    final int MAX = 100_000_000;

    int[] dy = {0, 1, 0, -1};
    int[] dx = {1, 0, -1, 0};

    int n;
    int height;

    public int solution(int[][] land, int height) {
        int answer = 0;

        this.n = land.length;
        this.height = height;

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(map[i], -1);

        // 1. 영역 색칠 (BFS)
        int area_color = 0;
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                paintBFS(i, j, area_color++, visited, land, map);
            }
        }

        // 2. 영역 간 연결 비용 수집 (반복 DFS)
        List<List<int[]>> area_adj = new ArrayList<>();
        for (int i = 0; i < area_color; i++) area_adj.add(new ArrayList<>());

        visited = new boolean[n][n]; // 방문 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;

                Map<Integer, Integer> adj_map = new TreeMap<>();
                connectAreaDFS(i, j, map, visited, adj_map, land);

                int curArea = map[i][j];
                for (Map.Entry<Integer, Integer> entry : adj_map.entrySet()) {
                    area_adj.get(curArea).add(new int[]{entry.getValue(), entry.getKey()});
                }
            }
        }

        // 3. 최소 스패닝 트리 (Prim)
        answer = prim(area_adj);

        return answer;
    }
    
    int prim(List<List<int[]>> area_adj) {
        int n = area_adj.size();
        
        boolean[] visited = new boolean[n];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0});
        
        int total = 0;
        
        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            
            int w = top[0];
            int v = top[1];
            
            if(visited[v]) continue;
            
            visited[v] = true;
            total+=w;
            
            for(int[] next : area_adj.get(v)) {
                if(visited[next[1]]) continue;
                
                pq.add(next);
            }
        }
        
        return total;
    }

    void paintBFS(int r, int c, int color, boolean[][] visited, int[][] land, int[][] map) {
        
        ArrayDeque<int[]> stk = new ArrayDeque<>();
        
        stk.push(new int[]{r,c});
        
        while(!stk.isEmpty()) {
            int[] top = stk.pop();
            int y = top[0], x = top[1];
            
            visited[y][x] = true;
            map[y][x] = color;
            
            for(int i=0; i<4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(ny<0||ny>=n||nx<0||nx>=n) continue;
                if(visited[ny][nx]) continue;
                if(Math.abs(land[y][x]-land[ny][nx])>height) continue;
                
                stk.push(new int[]{ny, nx});
            }
        }
    }

    void connectAreaDFS(int startR, int startC, int[][] map, boolean[][] visited, Map<Integer, Integer> adj_map, int[][] land) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startR, startC});
        visited[startR][startC] = true;
        int baseArea = map[startR][startC];

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int r = cur[0], c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dy[i];
                int nc = c + dx[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;

                int neighborArea = map[nr][nc];

                if (neighborArea != baseArea) {
                    int diff = Math.abs(land[r][c] - land[nr][nc]);
                    if (!adj_map.containsKey(neighborArea) || adj_map.get(neighborArea) > diff) {
                        adj_map.put(neighborArea, diff);
                    }
                    continue;
                }

                if (visited[nr][nc]) continue;
                visited[nr][nc] = true;
                stack.push(new int[]{nr, nc});
            }
        }
    }
}
