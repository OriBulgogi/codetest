import java.util.*;
import java.io.*;

public class BOJ10845 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(bf.readLine());
        Queue<Integer> que = new LinkedList<>();
        int last =0;
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<n;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String S = st.nextToken();
            switch(S) {
                case "push" :
                    last = Integer.parseInt(st.nextToken());
                    que.offer(last);
                    break;
                case "pop" :
                    if(que.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(que.poll()).append("\n");
                    break;
                case "size" :
                    sb.append(que.size()).append("\n");
                    break;
                case "empty" :
                    if(que.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front" :
                    if(que.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(que.peek()).append("\n");
                    break;
                case "back" :
                    if(que.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(last).append("\n");
                    break;
            }
        }
        System.out.println(sb);
        }
}

