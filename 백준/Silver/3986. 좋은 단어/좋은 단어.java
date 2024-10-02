import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static boolean isGoodWord(String word){
        ArrayDeque<Character> stack = new ArrayDeque<>();

        char[] alpha = word.toCharArray();

        for(int i=0;i<alpha.length;i++){
            if(stack.isEmpty()){
                stack.addLast(alpha[i]);
                continue;
            }

            if( stack.peekLast().charValue() == alpha[i] ){
                stack.pollLast();
            }
            else{
                stack.addLast(alpha[i]);
            }        
        }

        if(stack.isEmpty())
            return true;
        else
            return false;
    }
    
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt=0;
        for(int i=0;i<N;i++){
            String str = br.readLine();

            if(isGoodWord(str))
                cnt++;
        }

        System.out.println(cnt);
    }
}