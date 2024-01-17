import java.io.*;
import java.util.*;


public class BOJ5430 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());

        for(int i=0; i<testCase; i++){
            Deque<Integer> qu = new LinkedList<>();

            String commandStr = bf.readLine();
            int arrLength = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine(), "[],"); //delimiter는 이와같이 다중으로 설정 가능하다.

            for(int quIndex=0; quIndex<arrLength; quIndex++){
                qu.add(Integer.parseInt(st.nextToken()));
            }
            AC(commandStr, qu);
        }
        System.out.println(sb);
    }

    static void AC(String commandStr, Deque qu){
        Boolean isReverse = false;
        for (char command: commandStr.toCharArray()){

            if(command == 'R' ) { //Reverve 변수의 not 연산후 다음 명령 수행
                isReverse = !isReverse;
                continue;
            }

            if (isReverse){ // 역방향이면
                if(qu.pollLast() == null){
                    sb.append("error\n");
                    return;
                }
            }
            if (!isReverse){ // 정방향이면
                if(qu.pollFirst() == null){
                    sb.append("error\n");
                    return;
                }
            }
        }

        sb.append("[");
        if(!qu.isEmpty()){ // 정상적으로 큐가 비어있는 경우 [] 만 출력하기 위함
            if (isReverse){ //역방향인 경우
                sb.append(qu.pollLast());
                int quLength = qu.size();
                for(int i=0; i<quLength; i++){
                    sb.append(","+qu.pollLast());
                }
            }else{
                sb.append(qu.pollFirst());
                int quLength = qu.size();
                for(int i=0; i<quLength; i++){
                    sb.append(","+qu.pollFirst());
                }
            }
        }
        sb.append("]\n");
    }
}
