import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder resultSb = new StringBuilder();

        while(true){
            String input = bf.readLine();
            if (input.equals("0")) break;
            int len = input.length();
            StringBuilder sb = new StringBuilder();

            for(int i=1; i<=len; i++) {
                sb.append(input.charAt(len - i));
            }
            int inputNum = Integer.parseInt(input);
            int reverseNum = Integer.parseInt(sb.toString());

            if (inputNum == reverseNum){
                resultSb.append("yes\n");
            }else{
                resultSb.append("no\n");
            }
        }
        System.out.println(resultSb);
    }
}
