import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int r1 = gcd(A,B);

        sb.append(r1+"\n"+((A*B)/r1));
        System.out.println(sb);

    }
    static int gcd(int A, int B){
        int result =0;

        while(B !=0){
            result = A%B;
            A = B;
            B = result;
        }

        return A;
    }
}