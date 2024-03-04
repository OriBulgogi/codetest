import java.io.*;
import java.util.*;

public class BOJ1764 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());//듣
        int M = Integer.parseInt(st.nextToken());//보

        HashMap<String, Integer> map = new HashMap();
        ArrayList<String> list = new ArrayList();

        for(int i=0; i<N; i++){
            map.put(bf.readLine(),i);
        }

        for(int i=0; i<M; i++){
            String notSaw = bf.readLine();
            if(map.containsKey(notSaw)){
                list.add(notSaw);
            }
        }
        System.out.println(list.size());
        Collections.sort(list);

        for (String s : list){
            System.out.println(s);
        }
    }
}
