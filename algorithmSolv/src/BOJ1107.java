import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(bf.readLine());
        int brokenNum =Integer.parseInt(bf.readLine());
        boolean[] brokenArr = new boolean[10];

        int result = Math.abs(target - 100); //초기값 설정
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i=0; i<brokenNum; i++){
            brokenArr[Integer.parseInt(st.nextToken())] = true;
        }
        for(int i =0; i<=999999; i++){
            String str = String.valueOf(i);
            int len = str.length();

            boolean isBreak = false;
            for(int j =0; j<len; j++){
                if(brokenArr[str.charAt(j) - '0']) {// 고장난 버튼을 누르는 경우
                    isBreak = true;
                    break;
                }
            }
            if(!isBreak){
                int min = Math.abs(target -i) +len;
                result = Math.min(min, result);
            }
        }
        System.out.println(result);

    }
}
