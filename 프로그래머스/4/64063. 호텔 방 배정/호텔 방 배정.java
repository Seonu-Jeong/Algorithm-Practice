import java.util.*;
class Solution {
    
    Map<Long,Long> parent = new TreeMap<>();
    Map<Long,Long> rank = new TreeMap<>();
    
    public long[] solution(long k, long[] room_number) {
        int n = room_number.length;
        long[] ans = new long[n];
        
        for(int i=0; i<n; i++) {
            long rm = room_number[i];
            
            if(parent.get(rm)==null){
                //todo
                parent.put(rm,rm);
                
                if(rm-1>=1 && parent.get(rm-1)!=null){
                    merge(rm, rm-1);
                }
                
                if(rm+1<=k && parent.get(rm+1)!=null){
                    merge(rm, rm+1);
                }
            }
            else{
                //todo
                rm = find(rm)+1;
                
                parent.put(rm,rm);
                
                merge(rm, rm-1);
                
                if(rm+1<=k && parent.get(rm+1)!=null){
                    merge(rm, rm+1);
                }
            }
            
            ans[i]=rm;
            
            //System.out.printf("rm:%d, root:%d\n",rm,find(rm));
        }
        
        return ans;
    }
    
    long find(long u) {
        if(u == parent.get(u)) return u;
        
        long result = find(parent.get(u));
        
        parent.put(u,result);
        
        return result;
    }
    
    void merge(long u, long v) {
        u = find(u); v=find(v);
        
        if(u==v) return;
        
        if(u<v){
            long tmp = u;
            u = v;
            v = tmp;
        }
        
        parent.put(v,u);
    }
    
    
}