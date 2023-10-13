import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LC746e {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] cost = new int[n];
        for(int i = 0;i < n;i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = new int[n];
        arr[0] = cost[0];
        arr[1] = cost[1];

        for(int i = 2;i < n;i++){
            arr[i] = cost[i] + Math.min(arr[i - 1], arr[i - 2]);
        }
        System.out.println(Math.min(arr[n - 1], arr[n - 2]));
    }
}
