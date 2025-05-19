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

        // 1. 영역 색칠
        int area_color = 0;
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                paintBFS(i, j, area_color++, visited, land, map);
            }
        }

        // 2. 영역 간 연결 비용 수집
        List<List<int[]>> area_adj = new ArrayList<>();
        for (int i = 0; i < area_color; i++) area_adj.add(new ArrayList<>());

        visited = new boolean[n][n]; // 방문 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;

                Map<Integer, Integer> adj_map = new TreeMap<>();
                connectAreaBFS(i, j, map, visited, adj_map, land);

                int curArea = map[i][j];
                for (Map.Entry<Integer, Integer> entry : adj_map.entrySet()) {
                    area_adj.get(curArea).add(new int[]{entry.getValue(), entry.getKey()});
                }
            }
        }

        // 3. 최소 스패닝 트리 (Prim’s algorithm)
        boolean[] areaVisited = new boolean[area_color];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0}); // 비용, 시작 영역

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0], area = cur[1];

            if (areaVisited[area]) continue;
            areaVisited[area] = true;
            answer += cost;

            for (int[] next : area_adj.get(area)) {
                if (!areaVisited[next[1]]) {
                    pq.offer(new int[]{next[0], next[1]});
                }
            }
        }

        return answer;
    }

    void paintBFS(int r, int c, int color, boolean[][] visited, int[][] land, int[][] map) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;
        map[r][c] = color;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0], x = cur[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                if (visited[ny][nx]) continue;
                if (Math.abs(land[y][x] - land[ny][nx]) > height) continue;

                visited[ny][nx] = true;
                map[ny][nx] = color;
                q.offer(new int[]{ny, nx});
            }
        }
    }

    void connectAreaBFS(int r, int c, int[][] map, boolean[][] visited, Map<Integer, Integer> adj_map, int[][] land) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;

        int curArea = map[r][c];

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0], x = cur[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;

                int neighborArea = map[ny][nx];

                if (neighborArea != curArea) {
                    int diff = Math.abs(land[y][x] - land[ny][nx]);
                    if (!adj_map.containsKey(neighborArea) || adj_map.get(neighborArea) > diff) {
                        adj_map.put(neighborArea, diff);
                    }
                    continue;
                }

                if (visited[ny][nx]) continue;

                visited[ny][nx] = true;
                q.offer(new int[]{ny, nx});
            }
        }
    }
}
