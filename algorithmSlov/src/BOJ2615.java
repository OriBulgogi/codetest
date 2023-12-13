import java.io.*;
import java.util.*;
public class BOJ2615 {
    public static void main(String[] args) throws IOException{
        //가로 19*19
        //세로 19*19
        //대각1 15*15
        //대각2 15*15
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int input[][] = new int[19][19];
        for(int i= 0; i<19; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0; j<19; j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int prev =0;
        int count =0;
        int resultColor=0;
        int resultPos[] =new int[2];

        for(int i= 0; i<19; i++){
            for(int j= 0; j<19; j++) {

                //수평
                if(prev == input[i][j] && input[i][j] !=0){
                    count++;
                    if(count ==5){
                        resultColor = input[i][j];
                        resultPos[0] = i;
                        resultPos[1] = j;
                    }
                    if(count == 6 && resultPos[1] ==  j  ){
                        resultColor =0;
                        resultPos[0] =0;
                        resultPos[1] =0;
                    }
                }else{
                    count =0;
                }
                prev = input[i][j];
            }
        }


    }
}
