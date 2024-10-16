class Solution {
    
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        if(n<a) return 0;
        
        if(n%a==0)
            answer = solution(a, b, (n/a)*b) + (n/a)*b;
        else
            answer = solution(a, b, (n/a)*b+(n%a)) + (n/a)*b;
        
        return answer;
    }
}