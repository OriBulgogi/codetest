import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
* 백트레킹(가지치기)
* DFS를 수행하되 더 이상 필요없는 노드를 쳐내는 행위
*
* */
public class BOJ15649 {
    static boolean check[];
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        check = new boolean[N];
        dfs(N, M, 0);
        System.out.println(sb);
    }
    static void dfs(int N, int M, int depth){

        if(depth == M){//조건의 깊이가 되면 정지
            for (int n : arr){
                sb.append(n+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++){
            if(!check[i]){
                check[i] = true;
                arr[depth]= i+1;
                dfs(N,M,depth+1);
                //i=1 당시
                check[i] = false;
            }
        }

    }
}
