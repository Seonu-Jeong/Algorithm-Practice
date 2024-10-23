import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		ArrayList<BigInteger> ret = new ArrayList<>();

		for(int i=0; i<N; i++) {
			String str = br.readLine();
			char[] charr = str.toCharArray();

			for(int le=-1,ri=0; ri<charr.length; ri++) {
				if(charr[ri]>='0'&&charr[ri]<='9') {
					if(le==-1) le=ri;

					if(ri==charr.length-1) {
						ret.add(new BigInteger(str.substring(le,ri+1)));
					}
				}
				else {
					if(le!=-1) {
						ret.add(new BigInteger(str.substring(le,ri)));
						le=-1;
						
					}
				}
			}

		}

		Collections.sort(ret);

		for(BigInteger val : ret) {
			System.out.println(val);
		}
	}
}