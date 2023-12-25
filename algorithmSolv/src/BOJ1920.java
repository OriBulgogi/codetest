import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 {
    static StringBuilder sb = new StringBuilder();
    static int[] arr1;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N1 =Integer.parseInt(bf.readLine());
        arr1 = new int[N1];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N1; i++){
            arr1[i] =Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);
        int N2 =Integer.parseInt(bf.readLine());
        StringTokenizer st2 = new StringTokenizer(bf.readLine());
        for(int i=0; i<N2; i++){
            sb.append(binarySearch(Integer.parseInt(st2.nextToken())));
        }
        System.out.println(sb);
    }
    static String binarySearch(int target){
        int mid = 0;
        int low = 0;
        int high = arr1.length-1;

        while (low <= high){
            mid = (high+low)/2;
            if(arr1[mid]<target){
                low = mid+1;
            }else if(arr1[mid]>target){
                high = mid-1;
            }else{
                if(arr1[mid] == target){
                    return "1\n";
                }else{
                    return "0\n";
                }
            }
        }
        return "0\n";
    }
}
