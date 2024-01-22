import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2606 {
    static int computerNumber;
    static int computerEdgeNumber;
    static Queue<Integer> qu = new LinkedList<>();
    static ArrayList<Integer>[] Edge;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        computerNumber = Integer.parseInt(bf.readLine());
        computerEdgeNumber = Integer.parseInt(bf.readLine());


        Edge = new ArrayList[computerNumber+1];
        for(int i=1; i<=computerNumber; i++){
            Edge[i] = new ArrayList<>();
        }
        for(int i=1; i<=computerEdgeNumber; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int targetNode = Integer.parseInt(st.nextToken());
            Edge[startNode].add(targetNode);
            Edge[targetNode].add(startNode);

        }
        if(computerEdgeNumber > 0){
            VirousBfs();
        }else{
            System.out.println("0");
        }

    }

    static void VirousBfs(){
        Queue<Integer> tempQu = new LinkedList<>();
        Boolean check[] = new Boolean[computerNumber+1];
        Arrays.fill(check, false);
        int cnt=0;
        tempQu.add(1);
        check[1] = true;


        while (!tempQu.isEmpty()){
            int currentNode  = tempQu.poll();

            for(int i=0; i< Edge[currentNode].size(); i++){
                int targetNode = Edge[currentNode].get(i);
                    if(!check[targetNode]){
                        tempQu.add(targetNode);
                        check[targetNode] = true;
                        cnt++;
                    }
            }
        }
        System.out.println(cnt);
    }
}
