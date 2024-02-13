import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LC48m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][n];
        

        for(int i = 0;i < n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0;j < n;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //mirror in the middle
        for(int row = 0;row < matrix.length;row++){
            int l = 0, r = matrix[0].length - 1;
            while(l < r){
                int temp = matrix[row][l];
                matrix[row][l] = matrix[row][r];
                matrix[row][r] = temp;
                l++;
                r--;
            }
        }
        //mirror in diagonal, [i, j] => (n - j - 1, n - i - 1)
        int col = matrix.length;
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < col;j++){
                int temp =  matrix[i][j];
                matrix[i][j] = matrix[matrix.length - j - 1][matrix.length - i - 1];
                matrix[matrix.length - j - 1][matrix.length - i - 1] = temp;
            }
            col--;
        }
        
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }

    }
}
