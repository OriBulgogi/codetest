import java.io.*;
import java.util.Arrays;

/*
n: 휴가일 수
* 월 ~ 일 어느 요일에 출발하는지에 따라 주말이 겹치는 일수가 다르다
* 주말이 겹치는 최소, 최대값을 출력하라
* */
public class KIS_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[] answer = new int[2];

        if(N >=7){
            answer[0] = (N/7) * 2 + (N%7 == 6 ? 1 : 0);
            answer[1] = (N/7) * 2 + Math.min((N%7), 2);
        } else{
            if(N == 6) answer[0] = 1;
            answer[1] = Math.min(N, 2);
        }

        System.out.println(Arrays.toString(answer) );
    }

}