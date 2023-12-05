import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1244 {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int switchNum = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        boolean[] switchStatus = new boolean[switchNum];


        for(int i =0; i< switchNum; i++){
            String str =st.nextToken();
            if(str.equals("1")){
                switchStatus[i] = true;
            }else{
                switchStatus[i] = false;
            }
        }
        int studentNum = Integer.parseInt(bf.readLine());

        for(int i=0; i<studentNum; i++){
            String[] MWindex = bf.readLine().split(" ");
            int pos = Integer.parseInt(MWindex[1])-1;
            if(MWindex[0].equals("1")){
                for(int m =pos; m<switchNum; m+=(pos+1)){
                    switchStatus[m] = !switchStatus[m];
                }
            }else{
                switchStatus[pos] = !switchStatus[pos];
                for(int w = 1; w<switchNum; w++){
                    if((pos-w) < 0 || (pos+w) >= switchNum){
                        break;
                    }
                    if(switchStatus[pos-w] == switchStatus[pos+w] ) {
                        switchStatus[pos-w] = !switchStatus[pos-w];
                        switchStatus[pos+w] = !switchStatus[pos+w];
                    }else{
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<switchNum; i++){
            if(i%20 ==0 && i !=0){
                sb.append("\n");
            }
            sb.append(((switchStatus[i]) ? 1 : 0 )+" ");

        }
        System.out.println(sb);
    }
}
