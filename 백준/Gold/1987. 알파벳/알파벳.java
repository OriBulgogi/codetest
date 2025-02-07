import java.util.*;
import java.io.*;
public class Main {
    static int R, C =0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] arr;
    static int[] visited = new int[26];

    static int answer=0;
    /*
    2 4
    CAAB
    ADCB
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];

        for (int i =0; i<R; i++){
            String s =  bf.readLine();

            for(int j=0; j<C; j++){
                arr[i][j] = s.charAt(j) ;
            }
        }
        dfs(0,0,arr,1);
        System.out.println(answer);
    }
    static void dfs(int x, int y, char[][] arr,int cnt ){
        int alphabet = arr[x][y] - 'A';
        visited[alphabet] = 1;

        for(int i =0; i<4; i++){
            int curX = x+dx[i];
            int curY = y+dy[i];

            if (curX >=0 && curX <R&& curY >=0&& curY<C && visited[arr[curX][curY] - 'A'] == 0){

                dfs(curX, curY, arr, cnt +1);
                visited[arr[curX][curY] - 'A'] = 0;
            }
        }
        if (cnt > answer) answer = cnt;
    }
}