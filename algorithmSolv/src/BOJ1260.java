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

        //인접 행렬구현
        /*
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
        */

        LinkedList<Integer>[] adjList = new LinkedList[node+1];

        for(int i =0; i<adjList.length; i++){
            adjList[i] = new LinkedList<Integer>();
        }

        for(int i=0; i<line; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            adjList[a].add(b);
            adjList[b].add(a);
        }
        for(int i=1; i<=node; i++){
            Collections.sort(adjList[i]);
        }

        dfsList(start, adjList);
        sb.append("\n");
        check = new boolean[node+1];
        bfsList(start, adjList);

        System.out.println(sb);
    }

    static void bfsList(int start, LinkedList<Integer>[] adjList){
        qu.add(start);
        check[start]=true;

        while(!qu.isEmpty()){
            start = qu.poll();
            sb.append(start+" ");
            Iterator<Integer> iter = adjList[start].listIterator(); //현재방문한 노드의 간선들
            while (iter.hasNext()){
                int targetNode = iter.next();
                if(!check[targetNode]){
                    check[targetNode] = true;
                    qu.add(targetNode);
                }
            }
        }
    }

    static void dfsList(int start, LinkedList<Integer>[] adjList){
        check[start] = true;
        sb.append(start+" ");

        Iterator<Integer> iter = adjList[start].listIterator();
        while (iter.hasNext()){
            int targetNode = iter.next();
            if(!check[targetNode]){
                dfsList(targetNode, adjList);
            }
        }

    }

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