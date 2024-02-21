import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(),"-");
        int result = Integer.MAX_VALUE;
        while (st.hasMoreTokens()){
            StringTokenizer plusSt = new StringTokenizer(st.nextToken(), "+");
            int tempVal =0;
            while(plusSt.hasMoreTokens()){
                tempVal += Integer.parseInt( plusSt.nextToken());
            }

            if(result == Integer.MAX_VALUE){
                result = tempVal;
            }else{
                result -= tempVal;
            }
        }
        System.out.println(result);
    }
}

