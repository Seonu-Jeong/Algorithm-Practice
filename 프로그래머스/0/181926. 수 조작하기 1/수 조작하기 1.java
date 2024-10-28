class Solution {
    public int solution(int n, String control) {
        int answer = 0;
        for(char ch : control.toCharArray()){
            switch(ch){
                case 'w' -> n=n+1;
                case 's' -> n=n-1;
                case 'd' -> n=n+10;
                case 'a' -> n=n-10;
            }
        }
        return n;
    }
}