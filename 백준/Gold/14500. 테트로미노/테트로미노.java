import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M ;
    static int max = Integer.MIN_VALUE;
    static int[][] tetriArray;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         tetriArray = new int[N][M];
         visited = new boolean[N][M];


         for (int i =0; i<N; i++){
             st = new StringTokenizer(br.readLine());
             for (int j=0; j<M; j++){
                tetriArray[i][j] = Integer.parseInt(st.nextToken());
             }
         }
        for (int i =0; i<N; i++){
            for (int j=0; j<M; j++){
                visited[i][j] = true;
                dfs(i, j, 1, tetriArray[i][j]);
                visited[i][j] =false;
            }
        }
        System.out.println(max);
    }

    static void dfs(int x, int y, int count, int sum){

        if(count == 4) {
            max = Math.max(max, sum);
            return ;
        }

        for (int i=0; i<4; i++){
            int currentX = x + dx[i];
            int currentY = y + dy[i];

            if (currentX <0 || currentX >=N || currentY <0 || currentY >=M ) continue;
            if (visited[currentX][currentY]) continue;

            if (count == 2 ){
                visited[currentX][currentY] = true;
                dfs(x, y, count+1, sum+ tetriArray[currentX][currentY]);
                visited[currentX][currentY] = false;
            }
            visited[currentX][currentY] = true;
            dfs(currentX, currentY, count+1, sum+ tetriArray[currentX][currentY]);
            visited[currentX][currentY] = false;
        }

    }
}