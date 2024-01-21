import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class LC907m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // int min = Integer.MAX_VALUE;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i < n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // int[] mins = new int[arr.length];
        // int sum = 0;
        // Arrays.fill(mins, Integer.MAX_VALUE);

        // for(int i = 1;i <= mins.length;i++){
        //     for(int j = 0;j < arr.length - i + 1;j++){
        //         mins[j] = Math.min(mins[j], arr[j + i - 1]);
        //         sum += mins[j];
        //         sum %= 1000000007;
        //     }
        // }
        
        Stack<int[]> stack = new Stack<>();
        int[] sums = new int[arr.length];
        // sums[0] = arr[0];
        for(int i = 0;i < arr.length;i++){
            int sum = 0;
            while(!stack.isEmpty() && stack.peek()[1] >= arr[i]){
                stack.pop();
            }
            int dis = 0;
            if(!stack.isEmpty()){
                dis = i - stack.peek()[0];
                sum += dis * arr[i];
                sum += sums[stack.peek()[0]];
            } else {
                sum += (i + 1) * arr[i];
            }
            sums[i] = sum;
            stack.add(new int[]{i, arr[i]});
        }

        int sum = 0;
        for(int i = 0;i < sums.length;i++){
            sum += sums[i];
            sum %= 1000000007;
        }


        System.out.println(sum);


    }

}
