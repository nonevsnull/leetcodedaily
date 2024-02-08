import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LC167m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i < n;i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());

        int l = 0, r = numbers.length - 1;
        
        while(l < r){
            int sum = numbers[l] + numbers[r];
            if(sum > target){
                r--;
            } else if(sum < target){
                l++;
            } else {
                System.out.println((l + 1) + " " + (r + 1));
                return;
            }
        }
    }
}
