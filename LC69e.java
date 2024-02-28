import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LC69e {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int x = Integer.parseInt(br.readLine());

        long l = -1;
        long r = x + 1;
        System.out.println(r);
        while(r - l > 1){
            long m = l + (r - l) / 2;
            System.out.println(r);
            if(m * m < x){
                l = m;
            } else {
                r = m;
            }
        }
        if(r * r == x){
            System.out.println(r);
        } else {
            System.out.println(l);
        }
    }

}
