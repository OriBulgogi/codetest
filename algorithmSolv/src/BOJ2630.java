import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2630 {
    static int [][] colorPaper;
    static int zeroPaper, onePaper;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        colorPaper = new int[N][N];

        for(int i =0; i<N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j=0; j<N; j++){
                colorPaper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Divide(0,0, N);
        System.out.println(zeroPaper +"\n"+ onePaper);
    }

    static void Divide(int row, int col, int size){
        if(CheckColor(row, col, size)){
            if(colorPaper[row][col] == 0){
                zeroPaper++;
            }else{
                onePaper++;
            }
            return;
        }
        int DivideSize = size/2; //4
        Divide(row, col, DivideSize); //1 사분면 0~4, 0~4
        Divide(row+DivideSize, col, DivideSize); //2 사분면 5~8,0~4
        Divide(row, col+DivideSize, DivideSize); //3 사분면 0~4, 5~8
        Divide(row+DivideSize, col+DivideSize, DivideSize); //4 사분면 5~8, 5~8

        //4개로 나뉘는 종이 탐색 재귀 호출
    }
    static boolean CheckColor(int row, int col, int size){
        int preValue = colorPaper[row][col];
        for(int i =row; i<row+size; i++){
            for (int j=col; j<col+size; j++){
                if(preValue != colorPaper[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
