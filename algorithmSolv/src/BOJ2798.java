import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int repeat = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        int result =0;
        int[] arr = new int[repeat];

        StringTokenizer st2 = new StringTokenizer(bf.readLine());
        for (int i=0; i<repeat; i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        for (int i=0; i<repeat; i++){
            if(arr[i] > goal) continue;
            for (int j=1; j<repeat; j++){
                if(arr[i]+arr[j] > goal || i==j) continue;
                for (int k=2; k<repeat; k++){
                    if(j==k || i ==k) continue;
                    int num =arr[i]+arr[j]+arr[k];
                    if(arr[i]+arr[j]+arr[k] == goal){
                        result = num;
                        break;
                    }
                    if(num > result  && num <= goal){
                        result =num;
                    }


                }
            }
        }
        System.out.println(result);

    }
}
