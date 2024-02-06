import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LC45m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i < n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        /*
         * 要点：
         * - 每一步往前走，都尽可能在当前step的情况下走到头，除非走不下去了
         * - 这时候就需要提取在之前走的过程中能够走得最远的那个点，step+1
         * - 重点在于，走到倒数第一个就行了，因为最后一个我们不会再跳了
         * - 每一步走到边缘：i == dis,保证了这一点
         * - nums.length - 1，保证最后一步不需要了
         * - 每一步的含义是
         *  - 想到达下一步，该怎么做
         *  - 从当前位置，如果i==dis，说明已经到边缘了，再走下去必须step+1
         *  - 走到倒数第一步即可：到达下一步，即在走下去，是否还需要step+1
         * 
         * 
         */
        int dis = 0;
        int maxdis = 0;
        int step = 0;
        for(int i = 0;i < nums.length - 1;i++){
            maxdis = Math.max(maxdis, i + nums[i]);

            if(i == dis){
                step++;
                dis = maxdis;
            }
        }
        System.out.println(step);

    }
}
