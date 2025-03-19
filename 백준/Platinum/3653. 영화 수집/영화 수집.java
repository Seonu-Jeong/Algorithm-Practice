/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
import java.io.*;

public class Main
{
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		new Main().outer();
	}
	
	void outer() throws Exception {
	    int t = Integer.parseInt(br.readLine());
		
		while(t-- != 0) {
		    solution();
		}
		
		bw.flush();
	}
	
	int n, m;
	
	void solution() throws Exception {
	    
	    st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    int last = n+m+1;
	    
	    int[] tree = new int[last];
	    Arrays.fill(tree, 0);
	    
	    int[] mp = new int[n+1];
	    
	    for(int i=1; i<=n; i++) {
	        update(tree, i, 1);
	        mp[n-i+1] = i;
	    }
	    
	    st = new StringTokenizer(br.readLine());
	    int next = n+1;
	    
	    for(int i=0; i<m; i++) {
	        int tmp = Integer.parseInt(st.nextToken());
	        
	        int answer = query(tree, last-1) - query(tree, mp[tmp]);
	        
	        update(tree, mp[tmp], -1);
	        update(tree, next, 1);
	        mp[tmp] = next++;
	        
	        if(i+1 != m)
	            bw.write(answer+" ");
	        else
	            bw.write(answer+"");
	    }
	    
	    bw.newLine();
	    
	}
	
	void update(int[] tree, int i,int diff) {
	    
	    while(i<tree.length) {
	        tree[i] += diff;
	        i += i & -i;
	    }
	}
	
	int query(int[] tree, int i) {
	    int result = 0;
	    
	    while(i>0) {
	        result += tree[i];
	        i -= i & -i;
	    }
	    
	    return result;
	}
}