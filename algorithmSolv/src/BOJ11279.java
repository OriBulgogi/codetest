import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Currency;

public class BOJ11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(bf.readLine());
        MaxHeap mh = new MaxHeap(100001);

        for (int i=0; i<N; i++){
            int x = Integer.parseInt(bf.readLine());
            if(x == 0){
                sb.append(mh.Delete() + "\n");
            }else{
                mh.Insert(x);
            }
        }
        System.out.println(sb);
    }
    public static class MaxHeap{
        int[] HeapArray;
        int CurrentSize;

        MaxHeap(int size){
            HeapArray = new int[size];
        }

         void Insert(int x){
            HeapArray[++CurrentSize] = x;
            for (int i =CurrentSize; i>1; i/=2){
                if(HeapArray[i] < HeapArray[i/2]){
                    break;
                }else{
                    Swap(i,i/2);
                }
             }
        }

        int Delete(){
            if(CurrentSize == 0){
                return 0;
            }
             int root = HeapArray[1];
            HeapArray[1] = HeapArray[CurrentSize];
            HeapArray[CurrentSize] =0;
            CurrentSize--;
            for(int i=1; i*2<=CurrentSize;){
                if(HeapArray[i] > HeapArray[i*2] && HeapArray[i] > HeapArray[i*2+1]){
                    break;
                }
                if(HeapArray[i*2] < HeapArray[i*2+1] && HeapArray[i*2+1] != 0){
                    Swap(i,i*2+1);
                    i = i*2+1;
                }else{
                    Swap(i,i*2);
                    i = i*2;
                }
            }
            return root;
        }

        void Swap(int a, int b){
            int temp = HeapArray[b];
            HeapArray[b] = HeapArray[a];
            HeapArray[a] = temp;
        }
    }
}

