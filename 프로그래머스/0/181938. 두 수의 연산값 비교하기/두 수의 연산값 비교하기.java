import java.util.*;
class Solution {
    public int solution(int a, int b) {
        int result1 = Integer.parseInt(String.valueOf(a)+String.valueOf(b));
        int result2 = 2 * a * b;
        int answer = Math.max(result1, result2);
        return answer;
    }
}