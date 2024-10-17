import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int N;
    static char[][] map;

    public static void main(String[] args) throws Exception {

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        
        for(int i=0; i<N; i++) {
            char[] chs = br.readLine().toCharArray();

            for(int j=0; j<N; j++) {
                map[i][j] = chs[j];
            }
        }

        System.out.println( compress(0, 0, N).toString() );
        
    }

    static StringBuilder compress(int y, int x, int size){

        StringBuilder ret = new StringBuilder("");
        
        if(check(y, x, size)) {
            return ret.append(map[y][x]);
        }

        int[] dy = {0, 0, size/2, size/2};
        int[] dx = {0, size/2, 0, size/2};

        ret.append('(');
        
        for(int i=0; i<4; i++){
            ret.append(compress(y+dy[i] , x+dx[i], size/2));
        }

        ret.append(')');
        

        return ret;
    }
    
    static boolean check(int y, int x, int size){

        char initial = map[y][x];
        
        for(int i=0; i<size; i++){

            for(int j=0; j<size; j++){
                if(map[y+i][x+j]!=initial)
                    return false;
            }
        }

        return true;
    }
   

}