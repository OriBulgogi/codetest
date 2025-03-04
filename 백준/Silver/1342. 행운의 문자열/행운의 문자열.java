import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] alphabet = new int[26];
    static int count = 0;
    static int length;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        length = str.length();
        for (int i=0; i<str.length(); i++){
            alphabet[str.charAt(i) -'a']++;
        }
        dfs(0, Integer.MAX_VALUE);
        System.out.println(count);
    }

    static void dfs(int idx, int prev){
        if(idx == length){
            count++;
            return;
        }

        for (int i=0; i<26; i++){
            if (alphabet[i] ==0) continue;

            if(prev != i ){
                alphabet[i]--;
                dfs(idx+1, i);
                alphabet[i] ++;
            }
        }
    }
}
