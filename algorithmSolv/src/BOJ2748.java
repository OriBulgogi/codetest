import java.io.*;
import java.util.*;

public class BOJ2748 {
    /*
    static Long[] DParr;
    */
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        /*
        DParr = new Long[N+1];
        DParr[0] =0L;
        DParr[1] =1L;
        */
        int recursive_result =Fib_recursive(N);
        //long DP_result =Fib_DP(N);
        System.out.println(recursive_result);

    }
    //일반적인 재귀 풀이
    static int Fib_recursive(int N) {
        if(N == 0) return 0;
        if(N == 1) return 1;

        return Fib_recursive(N - 1) + Fib_recursive(N - 2);
    }

    //DP : 재귀로 하되 메모제이션
    /*
    static long Fib_DP(int N) {
        if(DParr[N] == null) {	// 해당 배열에 값이 없을경우 재귀호출
            DParr[N] = Fib_DP(N - 1) + Fib_DP(N - 2);
        }
        return DParr[N];
    }
    */

}
