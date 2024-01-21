import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LC198m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[n];

        for(int i = 0;i < n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int sumWithLast = nums[0];
        int sumWithOutLast = 0;
        for(int i = 1;i < nums.length;i++){
            int temp = sumWithLast;
            sumWithOutLast += nums[i];
            sumWithLast = Math.max(sumWithOutLast, sumWithLast - nums[i - 1] + nums[i]);
            sumWithOutLast = temp;
        }
        int r = sumWithLast > sumWithOutLast ? sumWithLast : sumWithOutLast;
        System.out.println(r);
    }
}
