import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LC6m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        String s = br.readLine();
        int numRows = Integer.parseInt(br.readLine());

        if(numRows == 1){
            System.out.println(s);
        }

        List<StringBuilder> lst = new ArrayList<>();
        for(int i = 0;i < numRows;i++){
            StringBuilder sb = new StringBuilder();
            lst.add(sb);
        }
        lst.get(0).append(s.charAt(0));
        int row = 1;
        int step = 1;
        
        for(int i = 1;i < s.length();i++){
            lst.get(row).append(s.charAt(i));
            if(row == numRows - 1 || row == 0){
                step *= -1;
            }
            row += step;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < lst.size();i++){
            sb.append(lst.get(i).toString());
        }
        System.out.println(sb.toString());
    }
}
