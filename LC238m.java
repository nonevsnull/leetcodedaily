import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LC238m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i < n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        //最优：O(n) on time, O(1) on space
        //主要是利用原数组，将right保存为一个常数，滚动更新
        int[] pre = new int[nums.length];
        int pp = 1;
        for(int i = 0;i < nums.length;i++){
            pp *= nums[i];
            pre[i] = pp;
        }
        int right = 1;
        for(int i = nums.length - 1;i >= 0;i--){
            int l = i > 0 ? pre[i - 1] : 1;
            
            int temp = l * right;
            right *= nums[i];
            nums[i] = temp;
        }

        //优化：这里要用到前缀和/积
        //每个乘积实际都是左边和右边的前缀/后缀积的积
        //但这里还是要用到O(n) space
        // int[] pre = new int[nums.length];
        // int[] tail = new int[nums.length];
        // int pp = 1;
        // for(int i = 0;i < nums.length;i++){
        //     pp *= nums[i];
        //     pre[i] = pp;
        // }
        // int tp = 1;
        // for(int i = nums.length - 1;i >= 0;i--){
        //     tp *= nums[i];
        //     tail[i] = tp;
        // }
        // for(int i = 0;i < nums.length;i++){
        //     int l = i > 0 ? pre[i - 1] : 1;
        //     int r = i < nums.length - 1 ? tail[i + 1] : 1;
        //     nums[i] = l * r;
        // }

        //优化，为了不使用除法，改用log，当然这么做不好，因为精度问题
        //但这个想法还是很优秀的
        // long product = 1;
        // int zero = 0;
        // for(int i = 0;i < nums.length;i++){
        //     if(nums[i] != 0){
        //         product *= nums[i];
        //     } else {
        //         zero++;
        //     }
        // }
        // int[] arr = new int[nums.length];
        // for(int i = 0;i < arr.length;i++){
        //     int cur = nums[i];
        //     if(zero == 0){
        //         arr[i] = (int)Math.round((Math.pow(10, (Math.log10(Math.abs(product)) - Math.log10(Math.abs(nums[i]))))));
        //         if(nums[i] * product < 0){
        //             arr[i] *= -1;
        //         }
        //     } else if(zero == 1){
        //         if(cur == 0){
        //             arr[i] = (int)product;
        //         } else {
        //             arr[i] = 0;
        //         }
        //     } else {
        //         arr[i] = 0;
        //     }
        // }


        //BF 用到除法
        // int product = 1;
        // int zero = 0;
        // for(int i = 0;i < nums.length;i++){
        //     if(nums[i] != 0){
        //         product *= nums[i];
        //     } else {
        //         zero++;
        //     }
        // }
        // int[] arr = new int[nums.length];

        // for(int i = 0;i < arr.length;i++){
        //     int cur = nums[i];
        //     if(zero == 0){
        //         arr[i] = product / cur;
        //     } else if(zero == 1){
        //         if(cur == 0){
        //             arr[i] = product;
        //         } else {
        //             arr[i] = 0;
        //         }
        //     } else {
        //         arr[i] = 0;
        //     }
        // }

        for(int i : nums){
            System.out.print(i + ", ");
        }

    }
}
