import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class LC452m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[][] points = new int[n][2];

        for(int i = 0;i < n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        
        List<int[]> lst = new ArrayList<>();

        for(int i = 0;i < points.length;i++){
            if(lst.size() == 0){
                lst.add(points[i]);
            } else {
                int[] cur = points[i];
                int[] last = lst.get(lst.size() - 1);

                if(cur[0] > last[1]){
                    lst.add(cur);
                } else {
                    last[0] = cur[0];
                    last[1] = last[1] > cur[1] ? cur[1] : last[1];
                }
            }
        }
        System.out.println(lst.size());
        
    }
}
