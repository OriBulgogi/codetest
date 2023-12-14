import java.io.*;
import java.util.*;
public class BOJ2615 {
    static int[][] map = new int[21][21];
    static int[][][] memo = new int[21][21][4];
    static int[] dx = { 1, 1, 0, -1 };
    static int[] dy = { 0, 1, 1, 1 };

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int input[][] = new int[19][19];
        for(int i= 1; i<=19; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=1; j<=19; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(findOmok());

    }
    private static String findOmok(){
        for(int j=1; j<=19; j++){
            for(int i=1; i<=19; i++){
                if(map[i][j] !=0){
                    for (int d=0; d<4; d++){
                        if(memo[i][j][d] ==0 &&  calc(i,j,d,map[i][j]) == 5){
                            return map[i][j] + "\n" + i + " " + j + "\n";
                        }
                    }
                }
            }
        }

        return "0";
    }

    private static int calc(int x, int y, int dir, int color){
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if(map[nx][ny] == color){ //다음 우측 대각, 좌측 대각, 수평, 수직이 같다면 계속 재귀호출을 한다.
            return memo[nx][ny][dir] = calc(nx, ny, dir, color) +1; //
        }
        return 1;
    }

}
