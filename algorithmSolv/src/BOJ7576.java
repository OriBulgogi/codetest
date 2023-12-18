import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {
    static StringBuilder sb = new StringBuilder();
    static int[][] NM;
    static int[]  X = {1, 0, -1 ,0};
    static int[]  Y = {0, -1, 0, 1};
    static Queue<int[]> qu = new LinkedList<>();
    static int cnt=0;
    static int N;
    static int M;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        NM = new int[M][N];
        boolean alreadyCheck = false;
        for(int i=0; i<M; i++){
            StringTokenizer stNM = new StringTokenizer(bf.readLine());
            for(int j=0; j<N; j++){
                NM[i][j] = Integer.parseInt(stNM.nextToken());
                if (NM[i][j] ==1){
                    qu.add(new int[]{i, j});
                }
                if(NM[i][j] == 0) alreadyCheck = true;
            }
        }
        System.out.println(bfsTomato(alreadyCheck));

    }

    static int bfsTomato(boolean alreadyCheck){
        if (!alreadyCheck){ //이미 다 익었다면 바로 0 리턴
            return 0;
        }
        int levelSize = qu.size(); //최소 queue 사이즈 측정

        while (!qu.isEmpty()){
            levelSize = qu.size();
            for (int levelIndex = 0; levelIndex<levelSize; levelIndex++){
                int [] currentQueue = qu.poll();
                for(int i=0; i<4; i++){
                    int t_x = X[i] + currentQueue[0];
                    int t_y = Y[i] + currentQueue[1];

                    if(t_x > -1 && t_y > -1 && t_x < M && t_y <N){
                        if (NM[t_x][t_y] == 0){
                            NM[t_x][t_y] = 1; //익표시
                            qu.add(new int[]{t_x, t_y}); //이번턴에 익은 토마토 큐에 추가
                        }
                    }
                }
            }
            cnt++; //이번턴이 끝나면 +1
        }

        //탐색이후 배열에 0이 남아있다면 익을수 없는 경우
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(NM[i][j] == 0){
                    return -1;
                }
            }
        }

        return cnt-1;
    }

}
