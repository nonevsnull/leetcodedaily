import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LC119e {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int n = Integer.parseInt(br.readLine());
        br.close();

        int[][] arr = new int[n + 1][n + 1];

        for(int i = 0;i < n + 1;i++){
            for(int j = 0;j < i + 1;j++){
                if(j == 0 || j == i || i == 0){
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
            }
        }
        for(int i : arr[n - 1]){
            System.out.println(i);
        }
    }
}
