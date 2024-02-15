import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class LC73m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][m];
        
        
        for(int i = 0;i < n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0;j < m;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean first = matrix[0][0] == 0;
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1;i < matrix.length;i++){
            if(matrix[i][0] == 0){
                for(int j = 0;j < matrix[0].length;j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i = 1;i < matrix[0].length;i++){
            if(matrix[0][i] == 0){
                for(int j = 0;j < matrix.length;j++){
                    matrix[j][i] = 0;
                }
            }
        }
        if(first){
            for(int i = 1;i < matrix.length;i++){
                matrix[i][0] = 0;
            }
            for(int i = 1;i < matrix[0].length;i++){
                matrix[0][i] = 0;
            }
        }
        //需要使用额外space
        // List<int[]> lst = new ArrayList<>();
        // for(int i = 0;i < matrix.length;i++){
        //     for(int j = 0;j < matrix[0].length;j++){
        //         if(matrix[i][j] == 0){
        //             lst.add(new int[]{i, j});
        //         }    
        //     }
        // }
        // for(int[] p : lst){
        //     setZero(matrix, p[0], p[1]);
        // }
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        
    }
    static void setZero(int[][] matrix, int row, int col){
        for(int i = 0;i < matrix[0].length;i++){
            matrix[row][i] = 0;
        }
        for(int i = 0;i < matrix.length;i++){
            matrix[i][col] = 0;
        }
    }
}
