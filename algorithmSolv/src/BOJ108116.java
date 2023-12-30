import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ108116 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] Narr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            Narr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer Mst = new StringTokenizer(br.readLine());

        for(int i=0; i<M; i++){
            int cnt=0;
            int target = Integer.parseInt(Mst.nextToken());
            for(int j=0; j<N; j++){
                if(target == Narr[j]){
                    cnt ++;
                }
            }
            sb.append(cnt+" ");
        }

        System.out.println(sb);
    }
}
