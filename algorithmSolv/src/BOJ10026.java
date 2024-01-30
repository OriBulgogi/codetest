import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.registry.Registry;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ10026 {
    static int[] dX = {1,0,-1,0};
    static int[] dY = {0,1,0,-1};
    static char[][] Grid;
    static boolean[][] check;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        N = Integer.parseInt(bf.readLine());
        Grid = new char[N][N];
        check = new boolean[N][N];

        for (int i=0; i<N; i++){
            String s= bf.readLine();
            for (int j=0; j<N; j++) {
                Grid[i][j] = s.charAt(j);
            }
        }
        int count =0;

        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++) {
                if(!check[i][j]){
                    count++;
                    RGB(i,j);
                }
            }
        }
        sb.append(count+" ");
        count =0;
        check = new boolean[N][N];

        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++) {
                if(!check[i][j]){
                    count++;
                    RGB(i,j);
                }
            }
        }
        sb.append(count);
        System.out.println(sb);


    }
    /*DFS*/
    static void RGB(int x, int y){
        check[x][y] = true;
        char tmp_char = Grid[x][y];
        for (int i=0; i<4; i++){
            int rX = x + dX[i];
            int rY = y + dY[i];

            if(rX < 0 || rY < 0|| rX >=N || rY >= N) continue;
            if(!check[rX][rY] && Grid[rX][rY] == tmp_char){
                RGB(rX, rY);
            }
        }
        if (Grid[x][y] == 'G')
            Grid[x][y] = 'R';
    }
/*BFS*/
    /*
    static void RGB(int x, int y){
        Queue<int[]> RGBqueue = new LinkedList<>();
        RGBqueue.offer(new int[]{x,y});
        check[x][y] = true;

        while (!RGBqueue.isEmpty()){
            int[] index = RGBqueue.poll();
            int X = index[0];
            int Y = index[1];

            for(int i=0; i<4; i++) {
                int rX = X + dX[i];
                int rY = Y + dY[i];

                if (rX < 0 || rX >= N || rY < 0 || rY >= N) continue;
                if (check[rX][rY] || Grid[X][Y] != Grid[rX][rY]) continue;

                RGBqueue.offer(new int[]{rX, rY});
                check[rX][rY] = true;
            }
            if (Grid[X][Y] == 'G')
                Grid[X][Y] = 'R';
        }
    }

     */
}
