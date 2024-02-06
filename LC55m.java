import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LC55m {
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
         * 当前这个位置能否到达，取决于之前的位置最远能到达的地方；
         * 如果之前最远dis >= 当前位置i，那么就可以到达
         * 那么如果当前这个位置能到达，那么最远可达的地方就是当前位置+当前值
         * 如果之前最远dis < 当前位置i，那说明不可到达。任何时候出现不可到达，那就false了
         * 
         */

        int dis = 0;
        for(int i = 0;i < nums.length;i++){
            if(i > dis){
                System.out.println(false);
                return;
            }
            dis = Math.max(dis, i + nums[i]);
        }
        System.out.println(true);

        //BF O(n^2)
        // int[] visited = new int[nums.length];
        // visited[0]++;
        // for(int i = 0;i < nums.length - 1;i++){
        //     if(visited[i] == 0){
        //         continue;
        //     }
        //     int cur = nums[i];
        //     for(int j = 1;j <= cur;j++){
        //         if(j + i < nums.length){
        //             visited[j + i]++;
        //         }
        //         if(j + i == nums.length - 1){
        //             System.out.println("ok");
        //             return;
        //         }
        //     }
        // }
        // System.out.println("no");

    }
}
