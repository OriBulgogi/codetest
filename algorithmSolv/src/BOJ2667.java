import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2667 {
    static int N;
    static int[][] arr;
    static int[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];
        visited = new int[N][N];
        List<Integer> complexCount = new ArrayList<>();

        for(int i=0; i<N; i++){
            String str = bf.readLine();
            for(int j=0; j<N; j++){
                char s= str.charAt(j);
                arr[i][j]  = (s-'0');
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j] == 0 && arr[i][j] ==1){
                    visited[i][j] =1;
                    complexCount.add(bfs(i, j));

                }
            }
        }
        sb.append(complexCount.size()+"\n");
        Collections.sort(complexCount);
        for(int cnt : complexCount){
            sb.append(cnt+"\n");
        }
        System.out.println(sb);

    }
    static int bfs(int n , int m){
        int count=1;
        Queue<int[]> qu = new LinkedList<>();
        qu.offer(new int[] {n,m});

        while (!qu.isEmpty()){
            int[] temp = qu.poll();

            for(int i=0; i<4; i++){
                int x =  temp[0] + dx[i];
                int y =  temp[1] + dy[i];

                if(x<N && y<N && x>=0 && y>=0){
                    if(visited[x][y] == 0 && arr[x][y] ==1){
                        qu.offer(new int[] {x, y});
                        visited[x][y] =1;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
