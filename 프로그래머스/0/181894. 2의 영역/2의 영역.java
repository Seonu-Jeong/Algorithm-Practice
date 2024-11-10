class Solution {
    public int[] solution(int[] arr) {
        int le=-1;
        int ri=-1;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]==2){
                if(le==-1)
                    le=i;
                
                ri=i;
            }
        }
        
        if(le==-1)
            return new int[]{-1};
        
        int[] result = new int[ri-le+1];
        
        for(int i=le,j=0;i<=ri;i++,j++){
            result[j]=arr[i];
        }
        
        return result;
    }
}