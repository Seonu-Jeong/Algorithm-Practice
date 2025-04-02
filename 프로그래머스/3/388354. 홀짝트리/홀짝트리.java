import java.util.*;

class Solution {
    
    TreeMap<Integer, ArrayList<Integer>> adj = new TreeMap<>();
    /*
        |정점 번호|간선수|
    0 - 짝수, 짝수
    1 - 짝수, 홀수
    2 - 홀수, 홀수
    3 - 홀수, 짝수
    
    4 - |트리 정점 수|
    */
    ArrayList<int[]> treeInfo = new ArrayList<>();
    
    public int[] solution(int[] nodes, int[][] edges) {
        
        for(int node : nodes) {
            adj.put(node, new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        // 포레스트 순회하며 트리 구분
        // 트리별 간선 정보 저장
        Set<Integer> visited = new TreeSet<>();
        int treeNum = 0;
        for(int node : nodes) {
            if(visited.contains(node))
                continue;
            
            treeInfo.add(new int[]{0,0,0,0,0});
            dfs(node, visited, treeNum);
            treeNum++;
        }
        
        // treeInfo 순회하면서 트리 구분
        int[] answer = new int[]{0,0};
        
        for(int[] tree : treeInfo) {
            //홀짝 트리
            if(tree[0]==1){
                if(tree[1]+tree[3]+tree[0]==tree[4])
                    answer[0]++;
            }
            
            if(tree[2]==1){
                if(tree[1]+tree[2]+tree[3]==tree[4])
                    answer[0]++;
            }
            
            //역홀짝 트리
            if(tree[1]==1){
                if(tree[0]+tree[2]+tree[1]==tree[4])
                    answer[1]++;
            }
            
            if(tree[3]==1){
                if(tree[3]+tree[2]+tree[0]==tree[4])
                    answer[1]++;
            }
        }
        
        return answer;
    }
    
    void dfs(int here, Set<Integer> visited, int num) {
        visited.add(here);
        
        // treeInfo에 정보 추가
        if(here%2==0) {
            if(adj.get(here).size()%2==0) {
                treeInfo.get(num)[0]++;   
            }
            else {
                treeInfo.get(num)[1]++;   
            }
        }
        else {
            if(adj.get(here).size()%2==1) {
                treeInfo.get(num)[2]++;   
            }
            else {
                treeInfo.get(num)[3]++;   
            }
        }
        
        treeInfo.get(num)[4]++;
        
        // 순회
        for(Integer there : adj.get(here)) {
            if(visited.contains(there))
                continue;
            
            dfs(there, visited, num);
        }
    }
}