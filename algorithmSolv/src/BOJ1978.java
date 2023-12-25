import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int repeat =Integer.parseInt(bf.readLine());
        int cnt=0;

        StringTokenizer st =new StringTokenizer(bf.readLine());
        for (int i=0; i<repeat; i++){
            int num =Integer.parseInt(st.nextToken());
            boolean flag=true;

            for(int j=2; j<num; j++){
                if(num%j==0){
                    flag = false;
                    break;
                }
            }
            if(flag && num != 1) cnt++;

        }

        System.out.println(cnt);
    }
}
