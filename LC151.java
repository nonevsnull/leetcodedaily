import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LC151 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        String s = br.readLine();

        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = strs.length - 1;i >= 0;i--){
            if(!strs[i].isEmpty()){
                sb.append(strs[i]);
                sb.append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    
    }
}
