package book;

import java.util.HashMap;
public class failRate {
    public int[] solution(int N, int[] stages) {
        int[] answer ={};
        int[] userStay = new int[N+2];
        for(int i =0; i<stages.length; i++){
            userStay[stages[i]] += 1 ;
        }

        //Double stagesDouble = Integer.parseDouble(stages.length);

        HashMap<Integer, Double> failMap = new HashMap<>();
        double total  = stages.length;

        for(int i=1; i<=N; i++){
            if(userStay[i] == 0 ){
                failMap.put(i, 0.0);
            }else{
                failMap.put(i, userStay[i] / total);
                total =- userStay[i];
            }
        }
        return failMap.entrySet().stream().
                sorted((o1,o2) -> Double.compare(o2.getValue(), o1.getValue()))
                .mapToInt(HashMap.Entry::getKey).toArray();

    }
}
