/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;

	int n,m,k;

	void solution() throws Exception {
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		long[] a = new long[n+1];
		long[] tree = new long[n+1];

		for(int i=1; i<=n; i++) {
			long value = Long.parseLong(br.readLine());
			a[i] = value;
			update(tree,i,a[i]);
		}

		m += k;

		while(m-- != 0) {
			st = new StringTokenizer(br.readLine());

			int t1,t2;
			t1 = Integer.parseInt(st.nextToken());
			t2 = Integer.parseInt(st.nextToken());

			if(t1 == 1) {
			    long t3 = Long.parseLong(st.nextToken());
			    
				long diff = t3-a[t2];
				a[t2] = t3;
				update(tree, t2, diff);
			}
			else {
			    int t3 = Integer.parseInt(st.nextToken());
				System.out.println(sum(tree, t3) - sum(tree, t2-1));
			}
		}
	}

	void update(long[] tree, int i, long diff) {
		while(i<tree.length) {
			tree[i] += diff;
			i += (i&-i);
		}
	}

	long sum(long[] tree, int i) {
		long ans = 0;

		while(i>0) {
			ans += tree[i];
			i -= (i&-i);
		}

		return ans;
	}
}