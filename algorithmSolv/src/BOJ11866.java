import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ11866 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        LinkedList<Integer> list = new LinkedList<>();

        for (int i=1; i<=N; i++){
            list.add(i);
        }
        StringBuilder sb = new StringBuilder();

        sb.append('<');

        int targetNumber =0;
        while (list.size() > 1){
            targetNumber = (targetNumber + (K-1)) % list.size();
            sb.append(list.remove(targetNumber)).append(", ");
        }

        sb.append(list.remove()).append('>');
        System.out.print(sb);
    }
}
