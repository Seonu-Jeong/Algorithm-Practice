class Solution {
    public int solution(int[] num_list) {
        int sum = 0;
        int mul = 1;
        
        for(int x:num_list) {
            sum += x;
            mul *= x;
        }
        
        if(num_list.length >= 11)
            return sum;
        else
            return mul;
        
    }
}