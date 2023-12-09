import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1260 {

    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static int[][] arr;

    static int node, line, start;
    static Queue<Integer> qu = new LinkedList<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start= Integer.parseInt(st.nextToken());

        arr = new int[node+1][node+1]; //입력값 이 1부터 시작
        check = new boolean[node+1];

        for(int i = 0 ; i < line ; i ++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = arr[b][a] =  1;
        }
        dfsArray(start);
        sb.append("\n");
        check = new boolean[node+1];
        bfsArray(start);


        System.out.println(sb);
    }
    //인접 행렬구현 O(N²)
    static void bfsArray(int start){
        qu.add(start);
        check[start] = true;

        while(!qu.isEmpty()){
            start = qu.poll();
            sb.append(start+" ");

            for(int i =1; i <=node; i++){
                if(arr[start][i] == 1 && !check[i]){
                    qu.add(i);
                    check[i] = true;
                }
            }
        }

    }

    //인접 리스트 구현 O(N*E)
    static void bfsList(int start){

    }
    static void dfsArray(int start){

        check[start] = true;
        sb.append(start+" ");

        for(int i=0; i<=node; i++){
            if(arr[start][i] == 1 && !check[i]){
                dfsArray(i);
            }
        }
    }
}