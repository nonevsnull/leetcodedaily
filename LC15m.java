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

public class LC15m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i < n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // HashSet<List<Integer>> set = new HashSet<>();
        // for(int i = 0;i < nums.length;i++){
        //     List<List<Integer>> round = twosum(nums, -1 * nums[i], i);
        //     set.addAll(round);
        // }
        // List<List<Integer>> r = new ArrayList<>();
        // for(List<Integer> l : set){
        //     r.add(l);
        //     System.out.println(l);
        // }
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        for(int i = 0;i < nums.length;i++){
            List<List<Integer>> round = find(nums, nums[i], i + 1, nums.length - 1);
            set.addAll(round);
        }
        List<List<Integer>> r = new ArrayList<>();
        for(List<Integer> l : set){
            r.add(l);
            System.out.println(l);
        }

    }

    static List<List<Integer>> find(int[] nums, int target, int l, int r){
        List<List<Integer>> lst = new ArrayList<>();
        while(l < r){
            if(nums[l] + nums[r] + target == 0){
                List<Integer> found = new ArrayList<>();
                found.add(nums[l]);
                found.add(nums[r]);
                found.add(target);
                // Collections.sort(found);
                lst.add(found);
                l++;
                r--;
            } else if(nums[l] + nums[r] + target < 0){
                l++;
            } else {
                r--;
            }
        }
        return lst;
    }

    // static List<List<Integer>> twosum (int[] nums, int target, int tp){
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     List<List<Integer>> lst = new ArrayList<>();
    //     for(int i = 0;i < nums.length;i++){
    //         if(i == tp){
    //             continue;
    //         }
    //         int cur = nums[i];
    //         if(map.containsKey(target - cur)){
    //             List<Integer> r = new ArrayList<>();
    //             r.add(cur);
    //             r.add(target - cur);
    //             r.add(-1 * target);
    //             Collections.sort(r);
    //             lst.add(r);
    //             map.put(target - cur, map.get(target - cur) - 1);
    //             if(map.get(target - cur) == 0){
    //                 map.remove(target - cur);
    //             }
    //         } else {
    //             if(!map.containsKey(cur)){
    //                 map.put(cur, 0);
    //             }
    //             map.put(cur, map.get(cur) + 1);
    //         }
    //     }
    //     return lst;
    // }
}
