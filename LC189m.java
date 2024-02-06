import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LC189m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i < n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        /*
         * 这里的要点是
         * 往右挪动，等于是把右边的一部分搬到左边来了。
         * 那么如果我把整个array反过来，那么右边的那部分肯定就在左边了，只是方向反了
         * 因此我就把方向调一下。
         */
        
         reverse(nums, 0, nums.length);
         reverse(nums, 0, k);
         reverse(nums, k, nums.length);

         System.out.println(nums);

    }

    static void reverse(int[] nums, int start, int end){
        for(int i = start;i < (start + end) / 2;i++){
            int temp = nums[end - 1 - i + start];
            nums[end - 1 - i + start] = nums[i];
            nums[i] = temp;
        }
    }
}
