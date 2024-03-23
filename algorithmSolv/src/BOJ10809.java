import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String S = bf.readLine();
        StringBuilder sb = new StringBuilder();
        int alphabet[] = new int[26];
        Arrays.fill(alphabet, -1);

        for(int i=0; i<S.length(); i++){  //입력 문자 각각의 알파뱃 위치 생성
            char ch = S.charAt(i);

            if(alphabet[ch- 'a'] == -1){// a -> index 0
                alphabet[ch-'a'] =i;
            }
        }


        for (int i=0; i<alphabet.length; i++){  //a~z
            sb.append(alphabet[i]+" ");
        }
        System.out.println(sb);
    }
}
