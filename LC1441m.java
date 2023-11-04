import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class LC1441m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int m = Integer.parseInt(br.readLine());
        int[] target = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i < m;i++){
            target[i] = Integer.parseInt(st.nextToken());
        }
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int pos = 0;
        for(int i = 1;i <= n;i++){
            if(pos == m){
                break;
            } else {
                stack.push(i);
                System.out.println("Push");
                if(target[pos] != i){
                    stack.pop();
                    System.out.println("Pop");
                } else {
                    pos++;
                }
            }
        }
    }
}
