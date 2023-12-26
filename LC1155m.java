import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LC1155m {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][n * k > target ? n * k + 1 : target + 1];

        for(int i = 1;i <= k;i++){
            arr[1][i] = 1;
        }

        for(int i = 2;i <= n;i++){
            for(int j = 1;j <= k;j++){
                for(int m = 1;m <= (i-1) * k;m++){
                    arr[i][m + j] += arr[i - 1][m];
                    arr[i][m + j] %= 1000000007;
                    // for(int[] ar : arr){
                    //     for(int a : ar){
                    //         System.out.print(a + ",");
                    //     }
                    //     System.out.println("");
                    // }
                    // System.out.println("");
                }
            }
        }
        System.out.println(arr[n][target]);
        
     }
}
