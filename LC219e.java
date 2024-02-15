import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class LC219e {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i < n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            } else {
                if(i - map.get(nums[i]) <= k){
                    System.out.println(true);
                    return;
                } else {
                    map.put(nums[i], i);
                }
            }
        }
        System.out.println(false);

    }
}
