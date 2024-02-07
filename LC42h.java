import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LC42h {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[] height = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i < n;i++){
            height[i] = Integer.parseInt(st.nextToken());
        }

        int[] water = new int[height.length];
        int l = 0;
        for(int i = 0;i < height.length;i++){
            int cur = height[i];
            if(cur > l){
                l = cur;
            }
            water[i] = l - cur;
        }
        int r = 0;
        for(int i = height.length - 1;i >= 0;i--){
            int cur = height[i];
            if(cur > r){
                r = cur;
            }
            water[i] = Math.min(water[i], r - cur);
        }
        int count = 0;
        for(int i = 0;i < water.length;i++){
            count += water[i];
        }
        System.out.println(count);
    }
}
