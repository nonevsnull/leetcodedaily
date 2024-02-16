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

public class LC155m {
    public static void main(String[] args) throws IOException {
        MinStack ms = new MinStack();

        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.top());
        System.out.println(ms.getMin());

        //split by "/", then put each part in to stack if not empty
        //we only include items excluding "/"
        //if .., pop if stack size is not empty

    
        
    }
}

class MinStack {
    //create a stack of int[val, max_until_now], 
    Stack<int[]> stack;
    public MinStack() {
        this.stack = new Stack<>();
    }
    
    public void push(int val) {
        int min = val;
        if(!stack.isEmpty()){
            min = Math.min(stack.peek()[1], min);
        }
        stack.push(new int[]{val, min});
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}