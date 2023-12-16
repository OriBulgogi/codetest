import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class hyundai_autoever_2 {

    static StringBuilder sb = new StringBuilder();
    static ArrayList result = new ArrayList();
    static ArrayList<Integer> buildingQueue = new ArrayList();
    static int buildingNumber;
    public static void main(String[] args) throws IOException {
        // 5 :빌딩 갯수
        // 1 2 3 4 1 : 빌딩의 높이 (인덱스는 순서대로)
        // 출력 : 1, 4, 5
        //가장 멀리있는 빌딩으로 짬푸, 막혀있으면 당연히 못감
        Scanner sc = new Scanner(System.in);
        buildingNumber = sc.nextInt();
        for(int i = 0; i <buildingNumber; i ++){
            buildingQueue.add(sc.nextInt());
        }
        dfs(0);
    }
    static void dfs(int start){

        if((start+1) != buildingNumber){
            int currentTop = buildingQueue.get(start);
            int index = start;
            for(int i = start; i<buildingNumber; i++){
                if(currentTop <= buildingQueue.get(i)){
                    currentTop = buildingQueue.get(i);
                    index = i;
                }
            }
            sb.append(index+1);
            System.out.println(index+1);
            dfs(index);
        }
    }
}
