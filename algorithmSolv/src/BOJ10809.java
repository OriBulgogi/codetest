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

        for(int i=0; i<S.length(); i++){
            char ch = S.charAt(i);

            if(alphabet[ch- 'a'] == -1){
                alphabet[ch-'a'] =i;
            }
        }
        for (int i=0; i<alphabet.length; i++){
            sb.append(alphabet[i]+" ");
        }
        System.out.println(sb);
    }
}
