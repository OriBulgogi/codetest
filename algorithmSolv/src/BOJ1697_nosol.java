import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697_nosol {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        //연산 종류 현재 위치 -+ 1 or x2

    }

    static void BFS(){
        int time=0;
        int visited[] = new int[100001];

        Queue<Integer> qu = new LinkedList<>();
        qu.add(N);
        visited[N] = 1;
        while (!qu.isEmpty()){
            int temp = qu.poll();
            for (int i=0; i<3;i++ ){
                int next;

                if(i ==0){
                    next =temp +1;
                }else if(i ==1){
                    next = temp -1;
                }else{
                    next =temp*2;
                }
                if(next == K){
                    System.out.println(visited[temp]);
                    return;
                }
                if(next >= 0 && next < visited.length && visited[next] ==0){
                    qu.add(next);
                    visited[next] = visited[temp] +1;
                }
            }
        }
    }
}
