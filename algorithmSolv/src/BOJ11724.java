import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int Node = Integer.parseInt(st.nextToken());
        int Edge = Integer.parseInt(st.nextToken());



        int[][] edgeArr = new int[Edge][2];
        for (int i=0; i<Edge; i++){
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            edgeArr[A][B] = edgeArr[B][A]= 1;

        }
    }

    static int findConn(int[][] edgeArr){
        Queue<int[]> qu = new LinkedList<>();

        while (!qu.isEmpty()){
            int nu = qu.poll();


        }

        return 0;
    }
}
