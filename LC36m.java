import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class LC36m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        
        char[][] board = new char[9][9];

        for(int i = 0;i < 9;i++){
            board[i] = br.readLine().toCharArray();
        }

        for(int i = 0;i < 9;i++){
            int[] row = new int[9];
            int[] col = new int[9];
            for(int j = 0;j < 9;j++){
                if(board[i][j] != '.'){
                    row[board[i][j] - '1']++;
                    if(row[board[i][j] - '1'] > 1){
                        System.out.println(false);
                        return;
                    }
                }
                if(board[j][i] != '.'){
                    col[board[j][i] - '1']++;
                    if(col[board[j][i] - '1'] > 1){
                        System.out.println(false);
                        return;
                    }
                }
            }
        }
        for(int i = 0;i < 3;i++){
            for(int j = 0;j < 3;j++){
                int[] row = new int[9];
                for(int x = 0;x < 3;x++){
                    for(int y = 0;y < 3;y++){
                        int ix = i * 3 + x;
                        int iy = j * 3 + y;
                        if(board[ix][iy] != '.'){
                            row[board[ix][iy] - '1']++;
                            if(row[board[ix][iy] - '1'] > 1){
                                System.out.println(false);
                                return;
                            }
                        }                 
                    }
                }
            }
        }
        System.out.println(true);
        

        
    }
}
