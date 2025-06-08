import java.util.*;

class Solution {

    final long MOD = 1_000_000_007L;
    
    long[][] dp;
    
    int count, n;
    
    public int solution(int n, int count) {
        int answer = 0;
        
        this.count = count;
        this.n = n;
        
        dp = new long[n+1][count+1];
        for(int i=0; i<n+1; i++)
            Arrays.fill(dp[i], -1);
        
        answer = (int)go(n, count);
        
        return answer;
    }
    
    long go(int cur, int cnt) {
        
        if(cur==0) {
            if(cnt==0)
                return 1;            
            else
                return 0;
        }
        
        if(dp[cur][cnt]!=-1)
            return dp[cur][cnt];
        
        long result = 0;
        
        result += (go(cur-1, cnt) * (n-cur) * 2)%MOD;
        
        if(cnt!=0)
            result = (result+go(cur-1, cnt-1))%MOD;
        
        dp[cur][cnt] = result;
        
        return result;
    }
}

/*
- 높이 1부터 n. 각각 2채 씩 총 2n
- 같은 높이를 가지는 빌딩 사이에는 그보다 높은 빌딩 존재하지 않음

- 결과 : n과 count가 주어졌을 때, 빌딩이 배치될 수 있는 방법의 수
ㄴ 결과가 매우 클 수 있으므로 나머지 값 리턴

- 같은 높이의 빌딩은 같은 색이므로 서로 구분하지 않음
*/