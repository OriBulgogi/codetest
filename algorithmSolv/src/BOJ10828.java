import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ10828 {
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            stackfunc(st);
        }
        System.out.print(sb);
    }

    static void stackfunc(StringTokenizer st){
        String Command =st.nextToken();
        int val=0;
        switch (Command){
            case "push": stack.push(Integer.parseInt(st.nextToken()));
                         break;

            case "top" : if(stack.isEmpty()){
                            sb.append("-1\n");
                        }else{
                            sb.append(stack.peek()+"\n");
                        }
                         break;

            case "size" : sb.append(stack.size() +"\n");
                         break;

            case "empty" : if(stack.isEmpty()){
                                sb.append("1\n");
                            }else{
                                sb.append("0\n");
                            }
                         break;

            case "pop" :if(stack.isEmpty()){
                            sb.append("-1\n");
                        }else{
                            sb.append(stack.pop()+"\n");
                        }
                        break;
        }

    }
}
