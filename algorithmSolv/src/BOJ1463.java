import java.awt.event.MouseAdapter;
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
    static Integer[] dp;
    static int X;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(bf.readLine());
        dp =new Integer[X+1];

        dp[0] = dp[1] =0;

        /*
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
        */
        System.out.println(madeOne(X));

    }
    //topdown
    static int madeOne(int N){
        if(dp[N] == null){ //타겟값이 null 이 아니면 값이 구해진것
            if(N % 6 ==0){
                dp[N] = Math.min(madeOne(N-1), Math.min(madeOne(N/3), madeOne(N/2)))+1 ;
            }else if(N%3 == 0){
                dp[N] = Math.min(madeOne(N-1), madeOne(N/3))+1 ;
            }else if(N%2 == 0){
                dp[N] = Math.min(madeOne(N-1), madeOne(N/2)) +1;
            }else{
                dp[N] = madeOne(N-1) +1;
            }
        }
        return dp[N];
    }
}
