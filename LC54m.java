import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LC54m {
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

        int[] east = new int[]{0, 1};
        int[] south = new int[]{1, 0};
        int[] west = new int[]{0, -1};
        int[] north = new int[]{-1, 0};

        int[][] directions = new int[][]{east, south, west, north};

        int direction = 0;
        int[] pos = new int[]{0, 0};
        List<Integer> lst = new ArrayList<>();

        while(lst.size() < matrix.length * matrix[0].length){
            lst.add(matrix[pos[0]][pos[1]]);
            matrix[pos[0]][pos[1]] = -1000;
            int[] next = new int[]{pos[0] + directions[direction][0], pos[1] + directions[direction][1]};
            if(next[0] >= matrix.length || next[0] < 0 || next[1] >= matrix[0].length || next[1] < 0 || matrix[next[0]][next[1]] == -1000){
                direction = (direction + 1) % directions.length;
            }
            pos = new int[]{pos[0] + directions[direction][0], pos[1] + directions[direction][1]};
        }
        System.out.println(lst);

    }
}
