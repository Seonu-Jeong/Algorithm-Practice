class Solution {
    public int solution(int[] arr1, int[] arr2) {
        
        if(arr1.length<arr2.length)
            return -1;
        else if(arr1.length>arr2.length)
            return 1;
        
        if(sum(arr1)<sum(arr2))
            return -1;
        else if(sum(arr1)>sum(arr2))
            return 1;
        else
            return 0;
        
    }
    
    int sum(int[] arr) {
        int result = 0;
        
        for(int x: arr){
            result += x;
        }
        
        return result;
    }
}