import java.io.*;
import java.util.*;

public class BOJ1181 {

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        String[] str = new String[N] ; //1. 중복제거 set
        for(int i=0; i<N; i++){
            str[i] = bf.readLine();
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }else{
                    return o1.length() - o2.length();
                }
            }
        });

        System.out.println(str[0]);
        for(int i=1; i<N; i++){
            if(!str[i].equals(str[i-1])){
                System.out.println(str[i]);
            }
        }
    }
}
