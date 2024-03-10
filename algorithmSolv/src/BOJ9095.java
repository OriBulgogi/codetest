import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase =  Integer.parseInt(bf.readLine());
        // dp[n] = d[n-1] + dp[n-2] + dp[n-3]
        for(int i=0; i<testCase; i++){
            int N = Integer.parseInt(bf.readLine());

            int[] dp = new int[11];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for(int j=4; j<=N; j++){
                dp[j] = dp[j-3] + dp[j-2] + dp[j-1];
            }
            sb.append(dp[N]+"\n");
        }
        System.out.println(sb);
    }
}
