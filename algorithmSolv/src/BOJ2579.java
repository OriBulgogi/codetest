import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ2579 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int stair = Integer.parseInt(bf.readLine());

        int[] stairScores = new int[stair+1];
        int[] dp = new int[stair+1];


        for(int i=1; i<=stair; i++){
            stairScores[i]  = Integer.parseInt(bf.readLine());
        }
        dp[1] = stairScores[1];

        if(stair >= 2){
            dp[2] = stairScores[1] +stairScores[2];
        }
        /*
         * 두 칸 전의 메모제이션 값(dp[i-2])  세 칸 전의 메모제이션 값 (dp[i-3]) + 한 칸 전의 메모제이션 값 중 큰것 과
         * 현재 계단의 값과 함하여 DP배열에 메모이제이션을 해주면 된다.
         * */
        for(int i=3; i<=stair; i++){
            dp[i] = Math.max(dp[i-2], dp[i-3] + stairScores[i-1]) + stairScores[i];
        }

        System.out.println(dp[stair]);

    }

    /*
    static int RecurStair(int N){
        if(dp[N] ==null){
            dp[N] = Math.max(RecurStair(N-2), RecurStair(N-3) + stairScores[N-1]) + stairScores[N];
        }
        return dp[N];
    }

     */
}
