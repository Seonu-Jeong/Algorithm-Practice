import java.util.*;
class Solution {
    public int solution(String[] words) {
        int N = words.length;
        
        Node[] roots = new Node[26];
        for(int i=0; i<26; i++) 
            roots[i]=new Node();
        
        for(String str : words) {
            //makeTree(roots[str.charAt(0)-'a'], str, 0);
            Node node = roots[str.charAt(0)-'a'];
            int pos=0;
            int cnt=0;
            while(true) {
                if(node.expect=="0")
                    node.expect=str;
                else
                    node.expect="-1";
                
                if(pos+1==str.length())
                    break;
                
                char ch = str.charAt(pos+1);
        
                Node next = null;

                if(node.map.containsKey(ch))
                    next = node.map.get(ch);
                else {
                    next = new Node();
                    node.map.put(ch, next);
                }
                
                node = next;
                pos++;
                cnt++;
            }
            //System.out.println(cnt);
        }
        
        int total=0;
        for(String str : words) {
            //total+=findCnt(roots[str.charAt(0)-'a'], str, 0);
            //System.out.println(total);
            
            Node node = roots[str.charAt(0)-'a'];
            int pos=0;
            int cnt=1;
            while(true) {
                if(!node.expect.equals("-1")){
                    break;
                }
                
                if(pos+1==str.length())
                    break;
                
                Node next = node.map.get(str.charAt(pos+1));
                cnt++;
                node=next;
                pos++;
            }
            total+=cnt;
            //System.out.println(total);
        }
        
        return total;
    }
    
    int findCnt(Node node, String str, int pos) {
        
        if(!node.expect.equals("-1")){
            return 1;
        }
        
        if(pos+1==str.length())
            return 1;
        
        Node next = node.map.get(str.charAt(pos+1));
        
        return findCnt(next, str, pos+1)+1;
    }
    
    void makeTree(Node node, String str, int pos) {
        
        if(node.expect=="0")
            node.expect=str;
        else
            node.expect="-1";
        
        if(pos+1==str.length())
            return;
        
        char ch = str.charAt(pos+1);
        
        Node next = null;
        
        if(node.map.containsKey(ch))
            next = node.map.get(ch);
        else {
            next = new Node();
            node.map.put(ch, next);
        }
        
        makeTree(next,str,pos+1);
    }
    
    static class Node {
        Map<Character,Node> map = new HashMap<>();
        String expect = "0";
    }
}