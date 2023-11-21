import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LC1838m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for(int i = 0;i < n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        for(int i:nums){
            System.out.print(i + " ");
        }
        int max = 0, count = 0;
        int r = nums.length - 1;
        Arrays.sort(nums);
        for(int l = nums.length - 1;l >= 0;l--){
            k -= nums[r] - nums[l];
            int rv = nums[r];
            count++;
            while(k < 0){
                int diff = rv - nums[r - 1];
                count--;
                k += diff * count;
                r--;
            }
            
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}


// class Solution {
//     /*
//         BF
//         for each item
//             - create new array find diff of each to the choice
//             - sort the new array
//             - start from beginning to meet budget
//             - count until budget is up
//         optimized
//         sort first
//         slide window from end
//      */
//     public int maxFrequency(int[] nums, int k) {
//         int max = 0;
//         for(int i = 0;i < nums.length;i++){
//             int count = 0;
//             int budget = k;
//             List<Integer> lst = diff(nums, nums[i]);
//             for(int j : lst){
//                 if(budget >= j){
//                     count++;
//                     budget -= j;
//                 } else {
//                     break;
//                 }
//             }
//             max = Math.max(max, count);
//         }
//         return max;
//     }

//     static List<Integer> diff(int[] nums, int choice){
//         List<Integer> lst = new ArrayList<>();
//         for(int i = 0;i < nums.length;i++){
//             if(choice >= nums[i]){
//                 lst.add(choice - nums[i]);
//             }
//         }
//         Collections.sort(lst);
//         return lst;
//     }
// }