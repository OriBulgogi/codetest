import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSort {
    static int[] arr, tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        tmp = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(0, n-1);


        System.out.println(Arrays.toString(arr));
    }
    static void mergeSort(int left, int right){
        if(left >= right) return;
        int mid = (left+right)/2;

        mergeSort(left,mid);
        mergeSort(mid+1,right);

        merge(left, mid, right);

    }

    static void merge(int left, int mid, int right){
        int L = left;
        int R = mid +1;
        int idx = L;
        while (L <= mid || R<= right){
            //1. 오른쪽 분할의 원소를 이미 다 가져온 경우
            //2. 왼쪽 분할에서 가져오지 않은 원소가 있고, 해당 원소(I)가 오른쪽 분할 원소(r)보다 작은 경우
            if(R>right || (L<=mid && arr[L] <arr[R])){
                tmp[idx++] = arr[L++];
            }else{
                tmp[idx++] = arr[R++];
            }
        }

        for(int i =left; i<=right; i++){ //앞쪽 데이터
            arr[i] = tmp[i];
        }
    }
}
