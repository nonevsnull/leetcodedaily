import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class LC931m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // int min = Integer.MAX_VALUE;
        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][n];

        for(int i = 0;i < n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0;j < n;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // HashMap<String, Integer> map = new HashMap<>();
        // for(int i = 0;i < n;i++){
        //     min = Math.min(min, dfs(matrix, 0, i, map));
        // }

        for(int i = matrix.length - 2;i >= 0;i--){
            for(int j = 0;j < matrix[0].length;j++){
                int min = matrix[i + 1][j];
                if(j - 1 >= 0){
                    min = Math.min(matrix[i + 1][j - 1], min);
                }
                if(j + 1 < matrix[0].length){
                    min = Math.min(matrix[i + 1][j + 1], min);
                }
                matrix[i][j] += min;
            }
        }


        int min = Integer.MAX_VALUE;
        for(int i = 0;i < matrix[0].length;i++){
            min = Math.min(min, matrix[0][i]);
        }
        System.out.println(min);

    }

    // static int dfs(int[][] matrix, int x, int y, HashMap<String, Integer> map){
    //     if(x == matrix.length){
    //         return 0;
    //     }
    //     if(map.containsKey(x + "," + y)){
    //         return map.get(x + "," + y);
    //     }

    //     int min = Integer.MAX_VALUE;
    //     min = Math.min(min, matrix[x][y] + dfs(matrix, x + 1, y, map));
    //     if(y - 1 >= 0){
    //         min = Math.min(min, matrix[x][y] + dfs(matrix, x + 1, y - 1, map));
    //     }
    //     if(y + 1 < matrix.length){
    //         min = Math.min(min, matrix[x][y] + dfs(matrix, x + 1, y + 1, map));
    //     }
    //     map.put(x + "," + y, min);
    //     return min;
    // }
}
