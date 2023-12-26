import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int repeat =Integer.parseInt(bf.readLine());
        int[] arr= new int[repeat];
        for (int i=0; i<repeat; i++){
            arr[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(arr);
        for (int i=0; i<repeat; i++){
            sb.append(arr[i]+"\n");
        }
        System.out.println(sb);
    }

}
