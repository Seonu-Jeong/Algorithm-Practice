import java.util.*;

class Solution {
    int k, n;
    int[][] reqs;
    int result = Integer.MAX_VALUE;

    public int solution(int k, int n, int[][] reqs) {
        this.k = k;
        this.n = n;
        this.reqs = reqs;

        // 각 유형에 최소 1명 배정한 상태에서 추가 멘토 배분
        int[] typeCount = new int[k + 1];
        Arrays.fill(typeCount, 1); // index 1부터 k까지 사용
        distribute(n - k, 1, typeCount);

        return result;
    }

    void distribute(int remain, int idx, int[] typeCount) {
        if (idx > k) {
            if (remain == 0) {
                result = Math.min(result, getWaitingTime(typeCount));
            }
            return;
        }

        for (int i = 0; i <= remain; i++) {
            typeCount[idx] += i;
            distribute(remain - i, idx + 1, typeCount);
            typeCount[idx] -= i;
        }
    }

    int getWaitingTime(int[] typeCount) {
        // 유형별로 우선순위 큐 사용 (상담 종료 시간이 빠른 순으로)
        ArrayList<PriorityQueue<Integer>> queues = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            queues.add(new PriorityQueue<>());
        }

        int waitSum = 0;
        for (int[] req : reqs) {
            int start = req[0];
            int duration = req[1];
            int type = req[2];
            PriorityQueue<Integer> pq = queues.get(type);

            if (pq.size() < typeCount[type]) {
                pq.offer(start + duration);
            } else {
                int availableTime = pq.poll();
                if (availableTime > start) {
                    waitSum += availableTime - start;
                    pq.offer(availableTime + duration);
                } else {
                    pq.offer(start + duration);
                }
            }
        }
        return waitSum;
    }
}
