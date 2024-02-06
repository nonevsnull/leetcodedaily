import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LC121e {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[] prices = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i < n;i++){
            prices[i] = Integer.parseInt(st.nextToken());
        }
    
        int min = Integer.MAX_VALUE;
        int profix = 0;
        for(int i = 0;i < prices.length;i++){
            int cur = prices[i];
            min = Math.min(min, cur);
            profix = Math.max(profix, cur - min);
        }
        System.out.println(profix);
    }
}
