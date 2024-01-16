import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
* (1) 현재 번호에서 + or - 로만 타겟 번호까지 갈때의 경우
* (2) 최대한 근사치 번호까지 누른 다음 +, - 를 이용해서 타켓 번호에 도달 했을 때의 경우
* */
public class BOJ1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(bf.readLine());
        int brokenNum =Integer.parseInt(bf.readLine());
        boolean[] brokenArr = new boolean[10];

        int result = Math.abs(target - 100); //초기값 설정

        if(brokenNum !=0){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int i=0; i<brokenNum; i++){
                brokenArr[Integer.parseInt(st.nextToken())] = true;
            }
        }

        for(int i =0; i<=999999; i++){ //N의 최댓값 500,000이므로 6자리수 최대 값 999,999까지 검사
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
