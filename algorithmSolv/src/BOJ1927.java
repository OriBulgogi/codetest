import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1927 {
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        //JavaLib(bf);
        MinHeap mh = new MinHeap(100001);
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(bf.readLine());
            if (x == 0) { //최소힙 delete
                System.out.println(mh.delete());
            } else {
                mh.insert(x);
            }
        }
    }
    public static class MinHeap{
        int[] HeapArray;
        int CurrentSize;
         public MinHeap(int size){
             HeapArray = new int[size];
        }
        private void insert(int x){
            HeapArray[++CurrentSize] = x;
            for(int i =CurrentSize; i>1; i/=2){
                if(HeapArray[i]  > HeapArray[i/2]){
                    break;
                }
                Swap(i/2, i);
            }
        }
        private int delete(){
            if(CurrentSize==0){
                return 0;
            }
            int root = HeapArray[1];
            HeapArray[1] =  HeapArray[CurrentSize];
            CurrentSize--;

            for(int i=1;  i*2<=CurrentSize;){
                if(HeapArray[i] < HeapArray[i*2] && HeapArray[i] < HeapArray[i*2+1] ){
                    break;
                }

                if(HeapArray[i*2] < HeapArray[i*2+1] ){
                    Swap(i*2, i);
                    i= i*2;
                }else{
                    Swap((i*2+1), i);
                    i= i*2+1;
                }
            }

            return root;
        }
        private void Swap(int A, int B){
            int temp = HeapArray[A];
            HeapArray[A] = HeapArray[B];
            HeapArray[B] = temp;
        }
    }
    public static void JavaLib(BufferedReader bf) throws IOException{
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(bf.readLine());
            if (x == 0) { //최소힙 delete
                if(pq.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(pq.poll());
                }
            } else {
                pq.offer(x);
            }
        }
    }
}
