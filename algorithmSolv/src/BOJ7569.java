import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {
    static Queue<int[]> qu = new LinkedList<>();
    static int[][][] Box;
    static int X[] = {-1, 0, 1, 0};
    static int Y[] = {0, 1, 0, -1};
    static int Z[] = {-1, 0, 1};
    static int N, M, H;
    static Boolean allDone = false;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        Box = new int[H][M][N];
        for(int i=0; i<H; i++){
            for(int j=0; j<M; j++){
                st = new StringTokenizer(bf.readLine());
                for(int k=0; k<N; k++){
                    Box[i][j][k] = Integer.parseInt(st.nextToken());
                    if(Box[i][j][k] == 1){
                        qu.add(new int[] {i,j,k});
                    }
                    if(Box[i][j][k] == 0){
                        allDone = true;
                    }
                }
            }
        }
        System.out.println(bfs(Box));
    }
    static int bfs(int[][][] Box){
        if(!allDone){
            return 0;
        }

        int cnt =0;
        while (!qu.isEmpty()){
            int currentQueueSize = qu.size();
            for(int r = 0; r<currentQueueSize; r++){
                int[] currentQueue = qu.poll();

                for(int layer=0; layer <=2; layer++) {
                    int dz = currentQueue[0] + Z[layer];

                    for (int i = 0; i < 4; i++) {
                        int dx = currentQueue[2] + X[i];
                        int dy = currentQueue[1] + Y[i];

                        if (dx > -1 && dy > -1 && dz > -1 && dx < N && dy < M &&  dz < H) {
                            if (Box[dz][dy][dx] == 0) {
                                Box[dz][dy][dx] = 1;
                                qu.add(new int[]{dz, dy, dx});
                            }
                        }
                    }
                }
            }
            System.out.println(Arrays.deepToString(Box));
            cnt ++;
        }

        for(int i=0; i<H; i++){
            for(int j=0; j<M; j++){
                for(int k=0; k<N; k++){
                    if(Box[i][j][k] == 0){
                        return -1;
                    }
                }
            }
        }

        return cnt;
    }
}
