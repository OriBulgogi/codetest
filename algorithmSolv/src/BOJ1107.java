import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(bf.readLine());
        int brokenNum =Integer.parseInt(bf.readLine());
        int[] brokenArr = new int[brokenNum];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i=0; i<brokenNum; i++){
            brokenArr[i]  = Integer.parseInt(st.nextToken());
        }


    }
}
