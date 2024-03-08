import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LC50m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        double x = Double.parseDouble(br.readLine());

        System.out.println(myPow(x, n));
    }
    static double myPow(double x, int n) {
        if(n == 1){
            return x;
        }
        if(n == -1){
            return 1/x;
        }
        if(n == 0){
            return 1;
        }
        double next = myPow(x, n / 2);
        return next * next * myPow(x, n % 2);
    }
}
