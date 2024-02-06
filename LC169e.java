import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class LC169e {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i < n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

    //    HashMap<Integer, Integer> map = new HashMap<>();

    //    for(int i = 0;i < nums.length;i++){
    //         int cur = nums[i];
    //         if(!map.containsKey(cur)){
    //             map.put(cur, 0);
    //         }
    //         map.put(cur, map.get(cur) + 1);
    //         if(map.get(cur) > n / 2){
    //             System.out.println(cur);
    //         }
    //    }
        //O(n), O(1)
        //这个点在于，最终赢家一定会比所有其他的之和多一票。所以如果不能保证这一点n/2，那就没法实现了
        int count = 0, can = 0;
        for(int i = 0;i < nums.length;i++){
            int cur = nums[i];
            if(count == 0){
                can = cur;
            }
            
            if(cur != can){
                count--;
            } else {
                count++;
            }
        }
        System.out.println(can);
    }
}
