import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class LC153m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i < n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        if(nums[0] <= nums[nums.length - 1]){
            System.out.println(nums[0]);
            return;
        }

        //f: x >= nums[0] && x > nums[nums.length - 1]
        int l = 0, r = nums.length;

        while(r - l > 1){
            int m = l + (r - l) / 2;
            if(nums[m] >= nums[0] && nums[m] > nums[nums.length - 1]){
                l = m;
            } else {
                r = m;
            }
        }
        System.out.println(nums[r]);

        
    }
}
