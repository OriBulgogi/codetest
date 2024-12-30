import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ1316 {
    public static void main(String[] args) throws IOException {
        // 단어의 갯수 N <100
        //N개의 단어 들어옴, 중복 x, 길이 100
        //Map 키로 넣어서 중복 체크 해버리기
        //임시로 이전값 들고 체크 ㄱㄱ

        HashMap<Character, Boolean> map = new HashMap<>();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int count =0;
        loop: for (int i =0; i<N; i++){
            String str = bf.readLine();
            char prev =str.charAt(0);
            map.put(prev, true);

            for(int j=1; j<str.length(); j++){
                char now = str.charAt(j);
                if(now != prev){
                    if(map.containsKey(now)){
                        map.clear();
                        continue loop;
                    }
                    map.put(now, true);
                }
                prev = now;
            }
            map.clear();

            count++;
        }
        System.out.println(count);
    }
}
