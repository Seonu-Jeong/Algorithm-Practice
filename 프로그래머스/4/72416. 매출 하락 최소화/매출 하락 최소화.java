import java.util.*;
class Solution {
    
    final long MAX = (long)1e18;
    
    int[] sales;
    boolean[] reader_flag;
    int n;
    List<List<Integer>> adj = new ArrayList<>();
    
    long[] cache_select;
    long[] cache_no;
    
    public int solution(int[] sales, int[][] links) {
        int answer = 0;
        
        //초기화
        this.sales=sales;
        this.n = sales.length;
        reader_flag = new boolean[n+1];
        
        cache_select = new long[n+1];
        Arrays.fill(cache_select, -1);
        cache_no = new long[n+1];
        Arrays.fill(cache_no, -1);
        
        //인접리스트 
        for(int i=0; i<n+1; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] link : links) {
            int a=link[0], b=link[1];
            
            reader_flag[a]=true;
            adj.get(a).add(b);
        }
        
        answer = (int)Math.min(dpSelect(1), dpNoSelc(1));
        
        return answer;
    }
    
    boolean isLeader(int cur) {
        return reader_flag[cur];
    }
    
    long dpSelect(int cur) {
        
        if(cache_select[cur]!=-1)
            return cache_select[cur];
        
        long result_leader = 0;
        
        for(int next : adj.get(cur)) {
            if(isLeader(next)) {
                long result = Math.min(dpNoSelc(next), dpSelect(next));   
                result_leader += result;
            }
        }
        
        //System.out.printf("select cur:%d ret:%d\n", cur, result_leader+sales[cur-1]);
        cache_select[cur] = result_leader+sales[cur-1];
        return result_leader+sales[cur-1];
    }
    
    
    long dpNoSelc(int cur) {
        
        if(cache_no[cur]!=-1)
            return cache_no[cur];
        
        boolean isSelc=false;
        long result_sum=0;
        
         //팀원 중 고르는 최소 비용
        long member_min = MAX;
        for(int next : adj.get(cur)) {
            if(isLeader(next)) continue;
            
            member_min = Math.min(member_min, sales[next-1]);
        }
        
        for(int next : adj.get(cur)) {
            if(!isLeader(next)) continue;
            
            long result1 = dpSelect(next);
            long result2 = dpNoSelc(next);

            if(result1<result2){
                isSelc=true;
            }
            
            member_min = Math.min(member_min, Math.abs(result1-result2));
            
            result_sum += Math.min(result1, result2);
        }
        
        if(isSelc) return result_sum;
        
        //System.out.printf("no cur:%d ret:%d\n", cur, result_sum);
        cache_no[cur] = result_sum+member_min;
        return result_sum+member_min;
    }

}

/*
- 직원은 직원 번호(1부터 순서대로 발급됨), 해당 직원의 하루평균 매출액을 가지고 있음

- 모든 직원은 팀장 또는 팀원이라는 직위를 가짐. CEO 포함
ㄴ 화살표 시작이 팀장, 받는 쪽은 팀원

- 직원 1번 CEO 고정 , CEO는 항상 팀장, 팀원일 수 없음
ㄴ 즉, 화살표 받을 수 없음

- CEO를 제외한 나머지는 다른 누군가로 부터 정확히 1개의 화살표 받음

- 한 직원은 최대 2개의 팀에 소속가능
ㄴ 한 직원이 2개의 팀에 소속되어 잇다면, 하나는 팀장, 하나는 팀원임

- 워크숍 참석 직원 선발 기준
ㄴ 모든 팀은 최소 1명 이상 직원을 워크숍 참석
ㄴ 참속하는 직원들의 하루평균 매출액의 합이 최소가 되어야 함

- 정답 값은 int로 해결됨
*/