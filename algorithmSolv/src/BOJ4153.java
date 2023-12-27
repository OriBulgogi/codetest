import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int A =Integer.parseInt(st.nextToken());
            int B =Integer.parseInt(st.nextToken());
            int C =Integer.parseInt(st.nextToken());
            if(A == 0 ){
                System.out.println(sb);
                break;
            }
            if((C*C) == (B*B + A*A)){
                sb.append("right\n");
            }else if(A*A == B*B + C*C){
                sb.append("right\n");
            }else if(B*B == A*A+C*C){
                sb.append("right\n");
            }else{
                sb.append("wrong\n");
            }
        }
    }
}
