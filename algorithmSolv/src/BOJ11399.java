import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr= new int[N];

        StringTokenizer st =new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int result =0;
        for(int i=0; i<N; i++){
            if (i != 0){
                arr[i] += arr[i-1];
            }
            result += arr[i];
        }
        System.out.println(result);
    }
}