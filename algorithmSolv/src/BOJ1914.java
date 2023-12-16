import java.io.*;
import java.math.BigInteger;

public class BOJ1914 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger bi = new BigInteger("2");
        BigInteger c = bi.pow(N).subtract(BigInteger.ONE); // 2^N -1
        System.out.println(c);
        if(N<=20){
            hanoi(N,1,2,3);
        }
        System.out.println(sb);
    }

    static void hanoi(int N, int from , int by, int to) {

        if (N == 1) {
            sb.append(from + " " + to + "\n");
            return;
        }else {
            hanoi(N-1, from, to, by);
            sb.append(from + " "+ to + "\n");
            hanoi(N-1, by, from, to);
        }
    }
}
