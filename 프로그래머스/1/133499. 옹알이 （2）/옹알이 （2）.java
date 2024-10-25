class Solution {
    public int solution(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        
        int cnt=0;
        
        for(String str : babbling){ 
            
            int before=-1;    
            boolean isSpeak = true;
            
            for(int le=0; le<str.length(); ){
                
                boolean isPossible=false;
                
                for(int i=0;i<4;i++){
                    int idx = str.indexOf(words[i],le);
                    
                    if(idx==le && before!=i){
                        le=words[i].length()+le;
                        before=i;
                        isPossible=true;
                        break;
                    }
                }
                
                if(!isPossible){
                    isSpeak=false;
                    break;
                }
            }
            
            if(isSpeak)
                cnt++;
        }
        
        return cnt;
    }
}