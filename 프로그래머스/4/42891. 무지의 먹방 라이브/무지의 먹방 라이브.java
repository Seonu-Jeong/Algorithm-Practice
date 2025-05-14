import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        int n = food_times.length;

        // 전체 음식 시간이 k보다 작거나 같으면 -1
        long total = 0;
        for (int t : food_times) total += t;
        if (total <= k) return -1;

        // (음식 시간, 인덱스) 형태로 정렬
        PriorityQueue<Food> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        for (int i = 0; i < n; i++) {
            pq.offer(new Food(food_times[i], i + 1));
        }

        long sum = 0; // 지금까지 제거한 시간 총합
        long previous = 0; // 이전에 제거된 음식 시간
        long length = n; // 남은 음식 수

        while (!pq.isEmpty()) {
            long now = pq.peek().time;
            long spend = (now - previous) * length;

            if (sum + spend > k) break;

            sum += spend;
            previous = now;
            pq.poll();
            length--;
        }

        // 남은 음식 리스트 인덱스 기준으로 정렬
        List<Food> rest = new ArrayList<>(pq);
        rest.sort(Comparator.comparingInt(a -> a.index));

        return rest.get((int)((k - sum) % length)).index;
    }

    static class Food {
        int time;
        int index;
        Food(int time, int index) {
            this.time = time;
            this.index = index;
        }
    }
}
