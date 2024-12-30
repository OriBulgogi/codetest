import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] orgiginArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++){
             orgiginArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(orgiginArr);

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int target;

        for (int i=0; i<M; i++){
            target = Integer.parseInt(st2.nextToken());
            int low = 0;
            int high = orgiginArr.length-1;

            binarySearch(orgiginArr, target, low, high);
        }
    }

    static void binarySearch(int[] arr, int target, int low, int high){

        int mid = (high+low)/2;

        if(target ==  arr[mid]){
            System.out.println(1);
            return;
        }else if(low > high){
            System.out.println(0);
            return;
        }else if(arr[mid] < target){
            low = mid+1;
        }else{
            high = mid-1;
        }

        binarySearch(arr, target, low, high);

    }
}
