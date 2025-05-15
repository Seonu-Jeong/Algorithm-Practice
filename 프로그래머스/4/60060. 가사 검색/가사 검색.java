import java.util.*;
class Solution {
    
    Node head = new Node();
    Node tail = new Node();
    
    public int[] solution(String[] words, String[] queries) {
        
        for(String str : words) {
            makeTrie(head, str, 0);
            makeTrie(tail, new StringBuilder(str).reverse().toString(), 0);
        }
        
        int[] ans = new int[queries.length];
        
        for(int i=0; i<queries.length; i++) {
            String str = queries[i];        
            int result=0;
            if(str.charAt(0)!='?') {
                result=search(head, str, 0);
            }
            else {
                result=search(tail, new StringBuilder(str).reverse().toString(), 0);
            }
            ans[i]=result;
        }
        
        return ans;
    }
    
    int search(Node node, String str, int pos) {
        
        char ch = str.charAt(pos);
        
        if(ch=='?'){
            Integer result = node.lenToCnt.get(str.length());
            
            if(result==null)
                return 0;
            
            return result;
        }
        Node next = node.childs.get(ch);
        
        if(next==null)
            return 0;
        
        return search(next, str, pos+1);
    }
    
    void makeTrie(Node node, String str, int pos) {
        
        //System.out.printf("str:%s pos:%d\n",str,pos);
        
        node.lenToCnt.put(str.length(), node.lenToCnt.getOrDefault(str.length(),0)+1);
        
        if(str.length()==pos)
            return;
        
        Node next = node.childs.get(str.charAt(pos));
        
        if(next==null) {
            next = new Node();
            node.childs.put(str.charAt(pos), next);
        }
        
        makeTrie(next, str, pos+1);
    }
    
    static class Node {
        Map<Integer,Integer> lenToCnt = new HashMap<>();
        Map<Character,Node> childs = new HashMap<>();
    }
}