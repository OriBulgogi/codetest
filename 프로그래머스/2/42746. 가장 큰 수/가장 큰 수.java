import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] stringNum = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            stringNum[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(stringNum, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        
        StringBuilder sb = new StringBuilder();
        for(String s : stringNum){
            sb.append(s);
        }
        
        if(stringNum[0].equals("0")) return "0";
            
        return sb.toString();
    }
}