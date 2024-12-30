import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 탐색?
 * 1. N = 참가자 수, M = 파티의 수
 * 2. 진실을 아는 참가자 리스트 hashmap [참가자][boolean]
 * 3. 파티의 별 참가자 <-> 진실을 아는 참가자 리스트 비교
 * 4. 진실을 모르는 파티 만큼 result 증산
 * */

/*
*
4 3
0
2 1 2
1 3
3 2 3 4
* */

public class BOJ1043 {
    static int[][] partyPeopleList;
    static int[][] turePeopleList;
    static HashMap<Integer, Boolean>  trueManList  = new HashMap<Integer, Boolean>();
    static int N, M ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        for(int i =1; i<=M; i++){
            trueManList.put(i, false);
        }


        int result = M;
        inputs = br.readLine().split(" ");
        if (inputs.length != 1){
            for(int i =1; i<=Integer.parseInt(inputs[0]); i++){
                trueManList.replace(Integer.parseInt(inputs[i]) , true);
            }
            System.out.println(trueManList.toString());

            for(int i =0; i<M; i++) {
                inputs = br.readLine().split(" ");
                if(inputs[0] == "0"){
                    continue;
                }
                for (int j=1; j<=Integer.parseInt(inputs[0]); j++){
                    System.out.println(trueManList.get(Integer.parseInt(inputs[j]) ));
                    if(trueManList.get(Integer.parseInt(inputs[j])) == true ){
                        result --;
                        break;
                    }
                }
            }
            System.out.println(result);
        }else{
            System.out.println(M);
        }
    }
}
