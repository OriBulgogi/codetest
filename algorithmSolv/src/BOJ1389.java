import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1389 {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] graph;
    static int[] check;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check = new int[N+1];
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        int MinValue=Integer.MAX_VALUE;
        int MinIndex =0;

        for(int i =1; i<=N; i++){
            int unitMinValue = bfs(i);
            if(MinValue > unitMinValue){ //어차피 index 가 낮은것부터 진행 되므로 동점은 고려 필요 x
                MinValue = unitMinValue;
                MinIndex =i;
            }
        }

        System.out.println(MinIndex);
    }
    static int bfs(int start){
        Arrays.fill(check, -1);
        Queue<Integer> qu = new LinkedList<>();
        qu.add(start);
        int cnt =0;
        check[start]=0;
        while (!qu.isEmpty()){
            int x = qu.poll();
            for (int y : graph[x]){
                if (check[y] != -1) continue;
                check[y] = check[x]+1;
                cnt += check[y];
                qu.add(y);
            }
        }
        return cnt;
    }
}
