import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

public class LC202e {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        while(!set.contains(n)){
            set.add(n);
            int total = 0;
            while(n > 0){
                int cur = n % 10;
                n = n / 10;
                total += cur * cur;
            }
            if(total == 1){
                System.out.println(true);
                return;
            }
            n = total;
        }
        System.out.println(false);

    }
}
