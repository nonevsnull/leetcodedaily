import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LC2742h {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int n = Integer.parseInt(br.readLine());
        int[] costs = new int[n];
        int[] times = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i < n;i++){
            costs[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < n;i++){
            costs[i] = Integer.parseInt(st.nextToken());
        }
    }

    // static int findSum(int[] costs, int[] times){
    //     for(int count = 1;count < costs.length;count++){
    //         for(int i = 0;i < costs.length;)
    //     }
    // }
}
