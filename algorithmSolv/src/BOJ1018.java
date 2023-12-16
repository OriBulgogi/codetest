import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
* 브루트 포스
* 1. 주어진 문제를 선형 구조로 구조화 한다.
* 2. 구조화된 문제공간을 적절한 방법으로 해를 구성할 때까지 탐색한다.
* 3. 구성된 해를 정리한다.
* */
public class BOJ1018 {
    static boolean[][] chess;
    static int N, M;
    static int min =64;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt( st.nextToken());
        M = Integer.parseInt( st.nextToken());
        chess = new boolean[N][M];

        for(int i =0; i<N; i++){
            String str = br.readLine();
            for(int j =0; j<M; j++){
                if(str.charAt(j) == 'W' ){ // W : true , B :false
                    chess[i][j] = true;
                }else{
                    chess[i][j] = false;
                }
            }
        }

        int Nrow = (N-7);
        int Mrow = (M-7);

        for(int i=0; i<Nrow; i++){
            for(int j=0; j<Mrow; j++){
                findMin(i,j);
            }
        }

        System.out.println(min);

    }
    static void findMin(int col, int row){
        int cnt =0;
        boolean hTF =true;
        boolean TF;
        for(int i=col; i<(8+col); i++){
            TF = hTF;
            hTF = (!hTF);
            for(int j=row; j<(8+row); j++){
                if(chess[i][j] == TF){
                    cnt++;
                }
                TF = (!TF);
            }
        }
        int currentmin = Math.min((64-cnt), cnt);

        if(currentmin < min){
            min =currentmin;
        }
    }
}
