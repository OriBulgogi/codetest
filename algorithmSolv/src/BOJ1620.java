import java.io.*;
import java.util.*;

public class BOJ1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> dogamInt = new HashMap<>();
        HashMap<String, Integer> dogam = new HashMap<>();


        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=N; i++){
            String s= bf.readLine();
            dogamInt.put(i, s);
            dogam.put(s, i);
        }

        for(int i=0;i<M; i++){
            String target = bf.readLine();
            if(49 <= target.charAt(0) && target.charAt(0) <= 57) {//String
                sb.append(dogamInt.get(Integer.parseInt(target))+"\n");
            }else{//Integer
                sb.append(dogam.get(target)+"\n");
            }
        }
        System.out.println(sb);
    }
}
