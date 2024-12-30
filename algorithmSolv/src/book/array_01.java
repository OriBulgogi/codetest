package book;

import java.util.Arrays;
import java.util.Collections;

public class array_01 {
    public static void main(String[] args) {
        //N^2 <-> NlogN 시간 복잡도 비교
        int[] arr = new int[100000];
        long start = System.currentTimeMillis();
        int[] bubble  = bubbleSort(arr);
        long end = System.currentTimeMillis();
        System.out.println((end-start)/1000.0 +"초");

        start = System.currentTimeMillis();
        int[] sort = doSort(arr);
        end = System.currentTimeMillis();
        System.out.println((end-start)/1000.0 +"초");

        //중복 제거, 내림차순 정렬
        Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);
        Arrays.sort(result, Collections.reverseOrder());
        Arrays.stream(result).mapToInt(Integer::intValue).toArray();

        // System.out.println(result);

    }
    private static int[] bubbleSort(int[] org){
        int[] arr= org.clone();
        int n = arr.length;
        for(int i = 0; i<n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
    private static int[] doSort(int[] org){
        int[] arr = org.clone();
        Arrays.sort(arr);

        return arr;
    }
}
