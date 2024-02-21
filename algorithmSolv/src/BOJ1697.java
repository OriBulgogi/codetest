import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {
    static int N, K;
    static int check[] = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if(N == K){
            System.out.println(0);
        }else {
            BFS(N);
        }
    }
    static void BFS(int start){
        Queue<Integer> qu = new LinkedList<>();
        qu.add(start);
        check[start] = 1;

        while(!qu.isEmpty()){
            int current = qu.poll();

            for(int i=0; i<3; i++){
                int next;

                if(i == 0) {
                    next = current + 1;
                }else if(i == 1){
                    next = current - 1;
                }else{
                    next = current * 2;
                }

                if(next == K){
                    System.out.println(check[current]);
                    return;
                }

                if(next >= 0 && next < check.length && check[next] == 0){
                    qu.add(next);
                    check[next] = check[current] + 1;
                }
            }
        }
    }
}
