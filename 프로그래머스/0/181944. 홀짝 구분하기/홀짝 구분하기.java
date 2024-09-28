import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        String answer = "";
        
        if(n%2==0)
            answer = " is even";
        else
            answer = " is odd";
        
        System.out.println(n+answer);
    }
}