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

public class LC71m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        String path = br.readLine();

        //split by "/", then put each part in to stack if not empty
        //we only include items excluding "/"
        //if .., pop if stack size is not empty

        String[] items = path.split("/");
        Stack<String> stack = new Stack<>();
        for(int i = 0;i < items.length;i++){
            String cur = items[i];
            if(cur.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                
            } else if(!cur.isEmpty() && !cur.equals(".")){
                stack.add(cur);
            }
        }
        String s = "";
        List<String> lst = stack.reversed();
        while(!stack.isEmpty()){
            s = stack.pop() + s;
            s = "/" + s;
        }
        if(s.isEmpty()){
            s += "/";
        }
        System.out.println(s);
        
    }
}
