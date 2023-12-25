import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int repeat =Integer.parseInt(bf.readLine());
        Queue<Integer> qu = new LinkedList<>();

        for (int i=1; i<=repeat; i++){
            qu.add(i);
        }

        while (qu.size() != 1){
            qu.poll();
            qu.add(qu.poll());
        }
        System.out.println(qu.poll());

    }
}
