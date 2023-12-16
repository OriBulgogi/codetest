import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2178 {
    /*
    *
    *
4 6
101111
101010
101011
111011
    *
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        String str;

        for(int i =0; i<N; i++){
            str = bf.readLine();
            for (int j=0; j<M; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }


    }
}
