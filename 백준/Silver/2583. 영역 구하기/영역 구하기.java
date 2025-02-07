import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] arr;
    static int N, M, size = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        StringBuffer sb = new StringBuffer();

        arr = new int[N][M];
        for(int i=0; i<K; i++){
            st = new StringTokenizer(bf.readLine());
            int leftY = Integer.parseInt(st.nextToken());
            int leftX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken());

            for(int X =leftX; X<rightX; X++){
                for(int Y =leftY; Y<rightY; Y++){
                    arr[X][Y] = 1;
                }
            }
        }
        int cnt=0;
        List<Integer> result= new ArrayList<>();
        for (int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if (arr[i][j] ==0){
                    size=0;
                    result.add(dfs(i, j));
                }
            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        for (int i : result){
            System.out.print(i +" ");
        }

    }
    static int dfs(int x, int y){
        size++;
        arr[x][y] = 1;
        for(int i=0; i<4; i++){
            int currentX = x+dx[i];
            int currentY = y+dy[i];

            if (currentX>=0 && currentX <N && currentY >=0 && currentY <M && arr[currentX][currentY] ==0){
                dfs(currentX, currentY);
            }
        }
        return size;
    }
}