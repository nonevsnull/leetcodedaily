import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class LC80m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i < n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int l = 1, count = 1, pre = nums[0];
        
        for(int i = 1;i < nums.length;i++){
            int cur = nums[i];
            if(pre == cur){
                count++;
            } else {
                count = 1;
            }
            pre = cur;
            if(count <= 2){
                nums[l] = nums[i];
                l++;
            }
        }
        System.out.println(l);
    }
}
