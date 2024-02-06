import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LC122m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[] prices = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i < n;i++){
            prices[i] = Integer.parseInt(st.nextToken());
        }

        int profit = 0;

        for(int i = 1;i < prices.length;i++){
            int diff = prices[i] - prices[i - 1];
            if(diff > 0){
                profit += diff;
            }
        }

        System.out.println(profit);

    }
}
