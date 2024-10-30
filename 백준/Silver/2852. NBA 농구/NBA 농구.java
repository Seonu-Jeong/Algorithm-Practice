/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
import java.io.*;

public class Main
{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
	public static void main(String[] args) throws Exception {
		int[] records = new int[48*60];
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++){
		    st = new StringTokenizer(br.readLine());
		    int team_num = Integer.parseInt(st.nextToken());
		    String goal_time_str = st.nextToken();
		    
		    st = new StringTokenizer(goal_time_str,":");
		    
		    int minute = Integer.parseInt(st.nextToken())*60;
		    int sec = Integer.parseInt(st.nextToken());
		    
		    int goal_time = minute+sec;
		    
		    if(team_num==1)
		        records[goal_time]++;
		    else
		        records[goal_time]--;
		}
		
		int cur_win=0;
		int team_1=0;
		int team_2=0;
		
		for(int i=0;i<records.length;i++){
		    cur_win+=records[i];
		    
		    if(cur_win>0)
		        team_1++;
		    else if(cur_win<0)
		        team_2++;
		}
		
		System.out.println(intTimeToString(team_1));
		System.out.println(intTimeToString(team_2));
	}
	
	static String intTimeToString(int time){
	    int minute = time/60;
	    int sec = time%60;
	    
	    String min_str = String.valueOf(minute);
	    String sec_str = String.valueOf(sec);
	    
	    if(minute<10)
	        min_str = "0"+min_str;
	        
	    if(sec<10)
	        sec_str = "0"+sec_str;
	    
	    return min_str+":"+sec_str;
	}
}

/* 문제
- 0초 및 48분 포함/미포함 구분
*/

/* 의사 코드

N 입력받기

크기 48*60+1 정수 배열 records 생성

N 번 반복하기 {
    팀 번호 입력받기    
    시간 입력받기
    
    시간 문자열을 정수로 변환 : goal
    (분*60+초)
    
    if 1번 팀이면:
        records[goal]++;
    else
        records[goal]--;
}

curwin = 0

records 배열 순회 {
    
    cur
}

*/