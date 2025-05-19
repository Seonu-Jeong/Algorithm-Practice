import java.util.*;

class Solution {

    final long INF = (long)1e18;
    int[] sales;
    int n;
    List<List<Integer>> adj = new ArrayList<>();
    long[] dpSelect;
    long[] dpNoSelc;

    public int solution(int[] sales, int[][] links) {
        this.sales = sales;
        this.n = sales.length;

        // 초기화
        dpSelect = new long[n + 1];
        dpNoSelc = new long[n + 1];
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        // 트리 구성
        for (int[] link : links) {
            int a = link[0], b = link[1];
            adj.get(a).add(b);
        }

        // 반복 기반 후위 순회 + DP
        postOrderDP(1);

        return (int) Math.min(dpSelect[1], dpNoSelc[1]);
    }

    void postOrderDP(int root) {
        boolean[] visited = new boolean[n + 1];
        Deque<Integer> stk1 = new ArrayDeque<>();
        Deque<Integer> stk2 = new ArrayDeque<>();

        stk1.push(root);
        while (!stk1.isEmpty()) {
            int cur = stk1.pop();
            stk2.push(cur);
            for (int next : adj.get(cur)) {
                if (!visited[next]) {
                    stk1.push(next);
                    visited[next] = true;
                }
            }
        }

        while (!stk2.isEmpty()) {
            int cur = stk2.pop();

            if (adj.get(cur).isEmpty()) {
                // 리프 노드
                dpSelect[cur] = sales[cur - 1];
                dpNoSelc[cur] = 0;
                continue;
            }

            long selectCost = sales[cur - 1];
            long noSelectCost = 0;
            boolean childSelected = false;
            long minGap = INF;

            for (int child : adj.get(cur)) {
                selectCost += Math.min(dpSelect[child], dpNoSelc[child]);

                if (dpSelect[child] <= dpNoSelc[child]) {
                    childSelected = true;
                    noSelectCost += dpSelect[child];
                } else {
                    noSelectCost += dpNoSelc[child];
                    minGap = Math.min(minGap, dpSelect[child] - dpNoSelc[child]);
                }
            }

            if (!childSelected) noSelectCost += minGap;

            dpSelect[cur] = selectCost;
            dpNoSelc[cur] = noSelectCost;
        }
    }
}
