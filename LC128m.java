import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class LC128m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i < n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i < nums.length;i++){
            set.add(nums[i]);
        }
        int max = 0;
        for(int i = 0;i < nums.length;i++){
            int cur = nums[i];
            if(set.contains(cur)){
                int total = 0;
                int lv = cur;
                while(set.contains(lv)){
                    total++;
                    set.remove(lv);
                    lv--;
                }
                int rv = cur + 1;
                while(set.contains(rv)){
                    total++;
                    set.remove(rv);
                    rv++;
                    
                }
                max = Math.max(max, total);
            }
        }
        System.out.println(max);

    }
}
