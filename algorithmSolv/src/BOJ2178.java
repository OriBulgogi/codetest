import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
    static int[][] arr;
    static int[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int M;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new int[N][M];
        String str;

        for(int i =0; i<N; i++){
            String S = bf.readLine();
            for (int j=0; j<M; j++){
                arr[i][j] = S.charAt(j) -'0';
            }
        }
        bfs();
    }

    static void bfs(){
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[] {0,0} );
        visited[0][0] = 1;
        while (!qu.isEmpty()){
            int[] currentPosition = qu.poll();
            int curX = currentPosition[0];
            int curY = currentPosition[1];

            for(int i =0; i<4; i++){
                int x = curX+ dx[i];
                int y = curY+ dy[i];
                if(x >=0 && y>=0 && x <N && y <M){
                    if(arr[x][y] == 1 && visited[x][y] == 0){
                        qu.offer(new int[] {x,y});
                        visited[x][y] = visited[curX][curY]+1;
                    }
                }
            }
        }
        System.out.println(visited[N-1][M-1]);
    }
}
