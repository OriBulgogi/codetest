import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M  = Integer.parseInt(br.readLine());
        int[] S = new int[21];
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String optimizer = st.nextToken();


            switch (optimizer){
                case "add" : S[Integer.parseInt(st.nextToken())] = 1;
                    break;
                case "remove" : S[Integer.parseInt(st.nextToken())] = 0;
                    break;
                case "check" : sb.append(S[Integer.parseInt(st.nextToken())] + "\n");
                    break;
                case "toggle" : int token =  Integer.parseInt(st.nextToken());
                                if(S[token] == 1){
                                    S[token] =0;
                                }else{
                                    S[token] =1;
                                };
                    break;
                case "all" : Arrays.fill(S, 1);
                    break;
                case "empty" :  Arrays.fill(S, 0);
                    break;
            }

        }
        System.out.println(sb);

    }
}