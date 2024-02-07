import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LC14 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] strs = new String[n];
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < n;i++){
            strs[i] = st.nextToken();
            min = Math.min(min, strs[i].length());
        }

        int count = 0;
        for(int i = 0;i < min;i++){
            
            char cur = strs[0].charAt(i);
            for(int j = 1;j < strs.length;j++){
                if(cur != strs[j].charAt(i)){
                    System.out.println(strs[0].substring(0, count));
                    return;
                }
            }
            count++; 
        }
        System.out.println(strs[0].substring(0, count));
    

    }
}
