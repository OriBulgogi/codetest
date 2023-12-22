import java.io.*;
import java.util.*;

/*
* DP 단계
* 1. 테이블 정의
* 2. 점화식 찾기
* 3. 초기값 정하기
*
* 1. D[i] = 정수가 i 를 1로 만들때 연산을 하는 횟수의 최솟값
*
* 2. D[12] = ?
* 3으로 나누거나 ( D[]
* */
public class BOJ1463 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(bf.readLine());
        int dp[] =new int[X+1];

        dp[0] = 0;
        dp[1] = 0;

        for(int i=2; i<=X; i++){
            dp[i] = dp[i-1] +1;
            if(i %2 == 0)
                dp[i] = Math.min(dp[i], dp[i/2] +1 );
            if(i %3 == 0)
                dp[i] = Math.min(dp[i], dp[i/3] +1 );
        }
        System.out.println(dp[X]);
    }
}
