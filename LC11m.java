import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LC11m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[] height = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i < n;i++){
            height[i] = Integer.parseInt(st.nextToken());
        }
        
        int l = 0, r = height.length - 1, max = 0;
        while(l < r){
            int d = Math.min(height[l], height[r]);
            max = Math.max(max, d * (r - l));
            if(height[l] < height[r]){
                l++;
            } else {
                r--;
            }
        }
        System.out.println(max);
    }
}
