import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LC289m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] board = new int[n][m];
        

        for(int i = 0;i < n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0;j < m;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //if dead, to -1; if revive, to 2
        for(int i = 0;i< board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                board[i][j] = check(board, i, j);
            }
        }
        for(int i = 0;i< board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                if(board[i][j] == -1){
                    board[i][j] = 0;
                }
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
            }
        }
        
        
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }

    }

    static int check(int[][] board, int x, int y){
        int count = 0;
        if(x - 1 >= 0 && y - 1 >= 0 && (board[x - 1][y - 1] == 1 || board[x - 1][y - 1] == -1)){
            count++;
        }
        if(x - 1 >= 0 && (board[x - 1][y] == 1 || board[x - 1][y] == -1)){
            count++;
        }
        if(x - 1 >= 0 && y + 1 < board[0].length && (board[x - 1][y + 1] == 1 || board[x - 1][y + 1] == -1)){
            count++;
        }
        if(y + 1 < board[0].length && (board[x][y + 1] == 1 || board[x][y + 1] == -1)){
            count++;
        }
        if(x + 1 < board.length && y + 1 < board[0].length && (board[x + 1][y + 1] == 1 || board[x + 1][y + 1] == -1)){
            count++;
        }
        if(x + 1 < board.length && (board[x + 1][y] == 1 || board[x + 1][y] == -1)){
            count++;
        }
        if(x + 1 < board.length && y - 1 >= 0 && (board[x + 1][y - 1] == 1 || board[x + 1][y - 1] == -1)){
            count++;
        }
        if(y - 1 >= 0 && (board[x][y - 1] == 1 || board[x][y - 1] == -1)){
            count++;
        }
        if(board[x][y] == 1 || board[x][y] == -1){
            if(count < 2 || count > 3){
                return -1;
            } else {
                return 1;
            }
        } else {
            if(count == 3){
                return 2;
            } else {
                return 0;
            }
        }
    }
}
