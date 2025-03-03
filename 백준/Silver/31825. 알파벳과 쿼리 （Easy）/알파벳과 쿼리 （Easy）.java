 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    private String str;
    private static char[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new char[N];
        String str = bf.readLine();
        for(int i=0; i<N; i++){
            arr[i] = str.charAt(i);
        }

        for (int i=0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            String optimizer = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(optimizer.equals("1")){
                System.out.println(countPackage(start, end));
            }else{
                convertAlphabet(start,end);
            }
        }
    }
    private static int countPackage(int start, int end){
        int cnt =1;
        char prev = arr[start-1];
        for (int i=start; i<end;i++){
            if(prev != arr[i]){
                cnt ++;
            }
            prev = arr[i];
        }
        return cnt;
    }
    private static void convertAlphabet(int start, int end){
        for(int i=start-1; i<end; i++){
            if(arr[i] == 'Z'){
                arr[i] = 'A';
            }else{
                arr[i]++;
            }
        }
    }
}