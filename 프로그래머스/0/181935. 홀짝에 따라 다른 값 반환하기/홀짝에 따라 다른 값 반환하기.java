class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if(n%2==0)
            answer = evenSolution(n);
        else
            answer = oddSolution(n);
        
        return answer;
    }
    
    int evenSolution(int n){
        
        int result = 0;
        
        for(int i=2; i<=n; i+=2){
            result += i*i;
        }
        
        return result;
    }
    
    int oddSolution(int n){
        int result = 0;
        
        for(int i=1; i<=n; i+=2) {
            result += i;
        }
        
        return result;
    }
}