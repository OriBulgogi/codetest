import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15650 {
    static int N,M, repeat;
    static int arr[];
    public static void main(String[] args) throws IOException {
        N = 4;
        M = 2;
        arr = new int[M];

        recursive(1, 0);
    }

    // 이 메소드는 무슨 메소드인가? 값을 하나씩 저장하고 그 값들을 통해 수열을 구성할 것
    static void recursive(int K, int idx){
        if(idx == M) {
            // 계산해야 되는 식
            // 출력해야 되는 값
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

       for(int i=K; i<M; i++){
            arr[i] = K;
            recursive(K+1, i+1);
       }
    }
}
