import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {

    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static int[][] arr;

    static int node, line, start;
    static Queue<Integer> qu = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start= Integer.parseInt(st.nextToken());

        arr = new int[node+1][node+1];
        check = new boolean[node+1];

        for(int i = 0 ; i < line ; i ++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = arr[b][a] =  1;
        }
        System.out.println(Arrays.deepToString(arr));
    }
    static void bfs(int start){
        qu.add(start);

        for(int i =0; i<line; i++){

        }

    }

}