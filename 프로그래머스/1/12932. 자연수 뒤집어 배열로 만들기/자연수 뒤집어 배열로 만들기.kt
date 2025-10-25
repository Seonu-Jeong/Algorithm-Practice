class Solution {
    fun solution(n: Long): IntArray {
        var answer = mutableListOf<Int>()
        var _n = n
        
        while (_n > 0) {
            answer.add((_n%10L).toInt())
            _n /= 10L
        }
        
        return answer.toIntArray()
    }
}