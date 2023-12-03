import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class dfs_bfs {

    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static int[][] arr;

    static int node, line, start;

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
        System.out.print(arr);

    }

}