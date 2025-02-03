class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        
        Boolean result = null;
        
        if(ineq.equals(">")){
            if(eq.equals("="))
                result = n>=m;
            else
                result = n>m;
        }
        else{
            if(eq.equals("="))
                result = n<=m;
            else
                result = n<m;
        }
        
        int returnValue=0;
        
        if(result)
            returnValue = 1;
            
        return returnValue;
    }
}