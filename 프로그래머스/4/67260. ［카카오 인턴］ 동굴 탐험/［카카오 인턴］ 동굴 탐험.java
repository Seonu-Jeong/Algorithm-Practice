import java.util.*;

class Solution {

    public boolean solution(int n, int[][] path, int[][] order) {

        // 1. 그래프 구성 (트리 간선만)
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : path) {
            int a = edge[0], b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        // 2. order 조건 맵
        Map<Integer, Integer> preMap = new HashMap<>(); // b -> a
        Map<Integer, List<Integer>> waitMap = new HashMap<>(); // a -> list of b

        for (int[] ord : order) {
            int a = ord[0], b = ord[1];
            preMap.put(b, a);
        }

        // 시작 노드 제약이 있으면 실패
        if (preMap.containsKey(0)) return false;

        // 3. 방문 처리
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        visited[0] = true;
        queue.offer(0);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            // cur를 선행 조건으로 기다리던 노드들 복귀
            if (waitMap.containsKey(cur)) {
                for (int w : waitMap.get(cur)) {
                    if (!visited[w]) {
                        visited[w] = true;
                        queue.offer(w);
                    }
                }
            }

            for (int next : adj.get(cur)) {
                if (visited[next]) continue;

                // 선행 조건이 있으면 대기
                if (preMap.containsKey(next)) {
                    int pre = preMap.get(next);
                    if (!visited[pre]) {
                        waitMap.computeIfAbsent(pre, k -> new ArrayList<>()).add(next);
                        continue;
                    }
                }

                visited[next] = true;
                queue.offer(next);
            }
        }

        // 4. 방문 누락된 노드가 있으면 false
        for (boolean v : visited) {
            if (!v) return false;
        }

        return true;
    }
}
