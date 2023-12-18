import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1012 {
    static int[][] cabbage;
    static boolean[][] visit;
    static Queue<int[]> qu = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static int[]  X = {1, 0, -1 ,0};
    static int[]  Y = {0, -1, 0, 1};
    static int N, M;

    // 1,0우 0,-1상 -1,0좌 0,1아래
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());//테스트 케이스 갯수

        for(int i =0; i<T; i++){
            StringTokenizer st1 = new StringTokenizer(bf.readLine());
            M = Integer.parseInt(st1.nextToken());//새로, 가로, 배추
            N = Integer.parseInt(st1.nextToken());
            int K = Integer.parseInt(st1.nextToken());
            cabbage = new int[M][N];
            visit = new boolean[M][N];
            int cnt=0;

            for(int j=0; j<K; j++){
                StringTokenizer st = new StringTokenizer(bf.readLine());
                cabbage[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]  = 1;
            }

            for (int row=0; row<M; row++){
                for (int col=0; col<N; col++){
                    if(cabbage[row][col] ==1 && !visit[row][col]){
                        visit[row][col] =  true;
                        bfs_bug(row, col);
                        cnt++;
                    }
                }
            }
            sb.append(cnt+ "\n");
        }
        System.out.println(sb.toString());
    }

    static void bfs_bug(int x_param, int y_param){
        qu.add(new int[] {x_param,y_param});

        while(!qu.isEmpty()){
            int[] qu_Val= qu.poll();
            for(int i=0; i<4; i++){
                int t_x = qu_Val[0] +X[i];
                int t_y = qu_Val[1] +Y[i];

                if(t_x > -1 && t_y > -1 && t_x <M && t_y < N)
                    if(cabbage[t_x][t_y] == 1 && !visit[t_x][t_y]){
                        qu.add(new int[] {t_x, t_y});
                        visit[t_x][t_y] = true;
                    }
            }
        }
    }

}
