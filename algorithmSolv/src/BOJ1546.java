import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int repeat =Integer.parseInt(bf.readLine());
        float[] scores = new float[repeat];
        float maxScore=0;
        float result =0;

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i=0; i<repeat; i++){
            scores[i] = Integer.parseInt(st.nextToken());
            if(maxScore < scores[i]) maxScore = scores[i];
        }

        for(int i=0; i<repeat; i++){
            result += ((scores[i]/maxScore)*100);
        }
        System.out.println(result/repeat);
    }
}
