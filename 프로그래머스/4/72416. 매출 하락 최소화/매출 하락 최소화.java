import java.util.*;

class Solution {

    List<List<Integer>> adj = new ArrayList<>();
    int[][] dp;
    int[] sales;
    boolean[] visited;
    int[] parent;

    public int solution(int[] sales, int[][] links) {
        this.sales = sales;
        int n = sales.length;

        dp = new int[n + 1][2]; // dp[i][0]: i번 직원이 참석 X / dp[i][1]: 참석 O
        visited = new boolean[n + 1];
        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] link : links) {
            int a = link[0], b = link[1];
            adj.get(a).add(b);
            parent[b] = a;
        }

        // 1. 후위 순회 순서대로 쌓기
        List<Integer> postOrder = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] tempVisited = new boolean[n + 1];
        stack.push(1);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            postOrder.add(node);
            for (int child : adj.get(node)) {
                if (!tempVisited[child]) {
                    stack.push(child);
                }
            }
            tempVisited[node] = true;
        }

        // 2. 바텀업으로 DP 계산
        Collections.reverse(postOrder); // 후위 순회이므로 역순 처리

        for (int cur : postOrder) {
            dp[cur][1] = sales[cur - 1]; // 자신이 참석하는 경우

            boolean mustAttend = false;
            int extraMin = Integer.MAX_VALUE;

            for (int child : adj.get(cur)) {
                dp[cur][1] += Math.min(dp[child][0], dp[child][1]);

                if (dp[child][1] < dp[child][0]) {
                    dp[cur][0] += dp[child][1];
                    mustAttend = true;
                } else {
                    dp[cur][0] += dp[child][0];
                    extraMin = Math.min(extraMin, dp[child][1] - dp[child][0]);
                }
            }

            if (!mustAttend && !adj.get(cur).isEmpty()) {
                dp[cur][0] += extraMin;
            }
        }

        return Math.min(dp[1][0], dp[1][1]);
    }
}
