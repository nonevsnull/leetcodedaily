import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LC300m {
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i < n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> lst = new ArrayList<>();
        dfs(nums, 0, lst);
        System.out.println(max);
    }

    static void dfs(int[] nums, int pos, List<Integer> lst){
        if(pos == nums.length){
            max = Math.max(max, lst.size());
            return;
        }

        int cur = nums[pos];
        if(lst.size() == 0 || cur > lst.get(lst.size() - 1)){
            lst.add(cur);
            dfs(nums, pos + 1, lst);
        } else{
            dfs(nums, pos + 1, lst);
            List<Integer> lstn = new ArrayList<>();
            int i = 0;
            while(lst.get(i) < cur){
                lstn.add(lst.get(i));
                i++;
            }
            lstn.add(cur);
            dfs(nums, pos + 1, lstn);
        }
        return;
    }
}
