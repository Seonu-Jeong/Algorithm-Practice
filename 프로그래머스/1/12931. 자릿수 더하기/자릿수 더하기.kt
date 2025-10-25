class Solution {
    fun solution(n: Int): Int {
        var answer = 0
        var _n = n
        
        while (_n > 0) {
            answer += _n % 10
            _n /= 10
        }
        
        return answer
    }
    
}