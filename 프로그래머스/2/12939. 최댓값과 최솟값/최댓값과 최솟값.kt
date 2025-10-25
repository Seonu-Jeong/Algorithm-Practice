class Solution {
    fun solution(s: String): String {
        var answer = ""
        
        val arr = s.split(' ').map(String::toInt)
        val maxV = arr.maxOrNull() ?: -1
        val minV = arr.minOrNull() ?: -1
        
        answer = "$minV $maxV"
        
        return answer
    }
}