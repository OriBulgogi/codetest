import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11724 {
    static int[][] edgeArr;
    static boolean[] nodeArr;
    static int Node, Edge;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Node = Integer.parseInt(st.nextToken());
        Edge = Integer.parseInt(st.nextToken());

        edgeArr = new int[Node+1][Node+1];
        nodeArr = new boolean[Node+1];

        for (int i=0; i<Edge; i++){
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            edgeArr[A][B] = edgeArr[B][A]= 1;

        }

        int count =0;
        for(int i=1; i<=Node;i++){
            if(nodeArr[i] == false){
                DFS(i);
                count++;
            }
        }
        System.out.println(count);
    }

    static void DFS(int value){
        if(nodeArr[value] == true){
            return;
        }
        nodeArr[value] = true;
        for(int i=1; i<=Node; i++){
            if(edgeArr[value][i] ==1){
                DFS(i);
            }
        }
    }
}
