import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class LC150m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        String[] tokens = new String[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i < n;i++){
            tokens[i] = st.nextToken();
        }

        //stack
        //if num, push to stack
        //if +-*/, pop 2 items, calculate, push back to stack
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < tokens.length;i++){
            String cur = tokens[i];
            if(Character.isDigit(cur.charAt(0)) || cur.length() > 1){
                stack.add(Integer.parseInt(cur));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                if(cur.equals("+")){
                    stack.push(b + a);
                } else if(cur.equals("-")){
                    stack.push(b - a);
                } else if(cur.equals("*")){
                    stack.push(b * a);
                } else if(cur.equals("/")){
                    stack.push(b / a);
                }
            }
        } 
        System.out.println(stack.peek());

    }
}
