import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class LC228e {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i < n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        List<String> lst = new ArrayList<>();

        int l = 0;
        while(l < nums.length){
            int start= nums[l];
            int r = l + 1;
            while(r < nums.length && nums[r] - nums[l] == 1){
                l++;
                r++;
            }
            int end = nums[l];
            if(start == end){
                lst.add(start + "");
            } else {
                lst.add(start + "->" + end);
            }
            l++;
        }
        System.out.println(lst);
    }
}
