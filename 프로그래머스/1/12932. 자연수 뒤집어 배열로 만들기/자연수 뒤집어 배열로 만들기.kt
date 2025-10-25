class Solution {
    fun solution(_n: Long): IntArray {
        var answer = mutableListOf<Int>()
        var n = _n
        
        while (n > 0) {
            answer.add((n%10L).toInt())
            n /= 10L
        }
        
        return answer.toIntArray()
    }
}