class Solution {
    public int solution(String myString, String pat) {
        return myString.toUpperCase().indexOf(pat.toUpperCase())!=-1?1:0;
    }
}