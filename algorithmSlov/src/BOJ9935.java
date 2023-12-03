import java.util.*;

public class BOJ9935 {
    //백준 9935 : 문자열 폭발
    static String characterExplo(){
        String result=null;
        Scanner sc = new Scanner(System.in);
        String  inputText = sc.next();
        String  inputBomb = sc.next();
        int bombleng =inputBomb.length();

        char[] OriginArray =inputText.toCharArray();
        char[] OriginBomb = inputBomb.toCharArray();

        Stack originStack = new Stack();

        for(int i =0; i < inputText.length(); i++) {
            originStack.push(OriginArray[i]);
            boolean flag = true; //탐색전 true 초기화

            //탐색문자와 bomb 문자 같아지면 탐색 시작
            if(originStack.size() >= bombleng){
                for(int j = 0; j <bombleng; j++ ){
                    if(!originStack.get(originStack.size()-bombleng +j).equals(OriginBomb[j])){
                        flag = false;
                    }
                }
                if(flag){ //플래그 걸린거 하나도없으면 문자열폭발
                    for(int popindex = 0; popindex<bombleng; popindex++){
                        originStack.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Object c : originStack){
            sb.append(c);
        }
        if(originStack.size() == 0){
            System.out.println("FRULA");
        }else{
            System.out.println(sb);
        }

        return result;
    }

    //현토에버 겨울인턴 2번째 문제 스파이더맨


    public static void main(String[] args) {
        characterExplo();

    }

}



