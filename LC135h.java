import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LC135h {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[] ratings = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i < n;i++){
            ratings[i] = Integer.parseInt(st.nextToken());
        }
        int[] can = new int[ratings.length];
        //主要技巧是两边各扫一遍
        //哪边扫出来的高度高，就必须选择那一边来作为高度
        for(int i = 0;i < ratings.length;i++){
            if(i - 1 >= 0 && ratings[i] > ratings[i - 1]){
                can[i] = can[i - 1] + 1;
            } else {
                can[i] = 1;
            }
        }
        for(int i = ratings.length - 1;i >= 0;i--){
            if(i + 1 < ratings.length && ratings[i] > ratings[i + 1]){
                can[i] = Math.max(can[i + 1] + 1, can[i]);
            }
        }
        for(int i = 0;i < can.length;i++){
            System.out.print(can[i] + ",");
        }
    }
}
