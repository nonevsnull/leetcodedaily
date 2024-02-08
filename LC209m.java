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

public class LC209m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i < n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());
        
        int l = 0, r = 0, min = Integer.MAX_VALUE, sum = 0;
        while(l <= r && r <= nums.length){
            if(sum >= target){
                min = Math.min(min, r - l);
                sum -= nums[l];
                l++;
            } else if(r < nums.length) {
                sum += nums[r];
                r++;
            } else {
                break;
            }
        }
        System.out.println(min);
    }
}
