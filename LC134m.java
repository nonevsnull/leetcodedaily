import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LC134m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[] gas = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i < n;i++){
            gas[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] cost = new int[m];
        st = new StringTokenizer(br.readLine());

        for(int i = 0;i < m;i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }
        
        //从头开始，如果余额为正，那没问题
        //如果余额为负，那说明经过的地方都不能当开始
        //因为如果有地方走不通，说明余额积累的不够，开始肯定不在前面，而在后面
        //因为我们一路攒过来都不够
        //那既然在后面，我们就把开始定在下一个
        //那就要多走一圈；因为从后面要绕道前面；但凡中途有负的，那说明无解
        //也可以先检查一下，所有的油和cost是不是保持有正的差异；
        int count = 0;
        int pos = 0;
        for(int i = 0;i < gas.length;i++){
            count += gas[i];
            count -= cost[i];
            if(count < 0){
                count = 0;
                pos = (i + 1) % gas.length;
            }
        }
        for(int i = 0;i < gas.length;i++){
            count += gas[i];
            count -= cost[i];
            if(count < 0){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(pos);
        


        //BF：O(n^2), O(1)
        // for(int i = 0;i < gas.length;i++){
        //     int count = 0;
        //     for(int j = 0;j < gas.length;j++){
        //         int gasid = (i + j) % gas.length;
        //         count += gas[gasid];
        //         count -= cost[gasid];
        //         if(count < 0){
        //             break;
        //         }
        //     }
        //     if(count >= 0){
        //         System.out.println(i);
        //         return;
        //     }
        // }
        // System.out.println(-1);

    }
}
