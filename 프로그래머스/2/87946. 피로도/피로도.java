import java.util.*;
class Solution {
    
    public int solution(int k, int[][] dungeons) {
        return permutation(dungeons.length, dungeons.length, 0, dungeons, k);
    }
    
    int permutation(int n, int r, int depth, int[][] dungeons, int k){
        if(r==depth){
            return maxDungeon(dungeons, k);
        }
        
        int ret=0;
        for(int i=depth; i<n; i++){
            
            int[] tmp = dungeons[i];
            dungeons[i] = dungeons[depth];
            dungeons[depth] = tmp;
            
            ret = Math.max(ret, permutation(n,r,depth+1,dungeons, k));
            
            tmp = dungeons[i];
            dungeons[i] = dungeons[depth];
            dungeons[depth] = tmp;
        }
        
        return ret;
    }
    
    int maxDungeon(int[][] dungeons, int k){
        int i=0;
        for(;i<dungeons.length;i++){
            if(k<dungeons[i][0])
                break;
            
            k-=dungeons[i][1];
        }
        
        return i;
    }
}