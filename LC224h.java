import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class LC224h {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        String s = br.readLine();
        /*
         * using stack
         * for cur char
         * if space, ignore
         * if ( or + or - , insert to stack
         * if num
         *      move to right until not digit
         *      if peek = + or -, pop
         *          if peek = num, pop, then calculate and push
         *          else push num or -num
         *      else 
         *          push to stack
         * for ), pop the number and (, push num back
         * 
         */
        int pos = 0;
        Stack<String> stack = new Stack<>();
        while(pos < s.length()){
            char cur = s.charAt(pos);
            if(cur == ' '){
                pos++;
            } else if(cur == '(' || cur == '+' || cur == '-'){
                stack.push(Character.toString(cur));
                pos++;
            } else {
                int op1 = 0;
                if(Character.isDigit(cur)){
                    int r = pos;
                    while(r < s.length() && Character.isDigit(s.charAt(r))){
                        r++;
                    }
                    op1 = Integer.parseInt(s.substring(pos, r));
                    pos = r;
                } else {
                    op1 = Integer.parseInt(stack.pop());
                    stack.pop();//"("
                    pos++;
                }
                
                if(!stack.isEmpty() && (stack.peek().equals("+") || stack.peek().equals("-"))){
                    int sign = stack.pop().equals("+") ? 1 : -1;
                    if(stack.isEmpty() || stack.peek().equals("(")){
                        stack.push(Integer.toString(op1 * sign));
                    } else {
                        int op2 = Integer.parseInt(stack.pop());
                        stack.push(Integer.toString(op1 * sign + op2));
                    }
                } else {
                    stack.push(Integer.toString(op1));
                }
            }
        }
        System.out.println(stack.peek());


    }
}
