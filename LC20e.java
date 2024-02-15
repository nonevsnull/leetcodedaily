import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class LC20e {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();

        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(stack.isEmpty() || c == '(' || c == '{' || c == '['){
                stack.add(null);
            } else {
                char p = stack.pop();
                if(c == ')' && p != '('){
                    System.out.println(false);
                }
                if(c == ']' && p != '['){
                    System.out.println(false);
                }
                if(c == '}' && p != '{'){
                    System.out.println(false);
                }
            }
            
        }
        System.out.println(stack.isEmpty());
        
    }
}
