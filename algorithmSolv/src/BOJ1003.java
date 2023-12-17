import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1003 {
    static Integer[][] dp = new Integer[41][2];


    public static void main(String[] args) throws IOException {
        dp[0][0] =1; //N=0 일 때의 0 호출 횟수
        dp[0][1] =0; //N=0 일 때의 1 호출 횟수
        dp[1][0] =0; //N=1 일 때의 0 호출 횟수
        dp[1][1] =1; //N=1 일 때의 1 호출 횟수

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int repeact = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<repeact; i++){
            int N =Integer.parseInt(bf.readLine());
            fb(N);
            sb.append(dp[N][0] + " " + dp[N][1]+"\n");
        }

        System.out.println(sb.toString());
    }

    static Integer[] fb(int N){
        //탐색 한적이 없는 경우
        if(dp[N][0] ==null || dp[N][1] ==null){
            //각 N에 대한 0, 1호출 횟수를 재귀호출한다.
            dp[N][0] = fb(N-1)[0] + fb(N-2)[0];
            dp[N][1] = fb(N-1)[1] + fb(N-2)[1];
        }
        return dp[N];
    }

}
