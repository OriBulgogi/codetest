import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] treeArr = new int[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            treeArr[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(treeArr);
        System.out.println(searchHight(N, M, treeArr));
    }

    static long searchHight(int N, int M, int[] treeArr){
        long high = treeArr[N-1];
        long low = 0;
        long mid = (high+low)/2;
        long answer = 0;

        while (low <= high){
            long hight = 0;
            mid = (high+low)/2;

            for (int tree : treeArr){
                if(tree-mid >0 ){
                    hight += tree-mid;
                }
            }
            if(hight < M){
                high = mid-1; // 남는 길이를 더 많이

            }else{
                answer = mid;
                low = mid+1;  // 남는 길이를 적게
            }
        }
        return answer;
    }
}
