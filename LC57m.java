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

public class LC57m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[][] intervals = new int[n][2];

        for(int i = 0;i < n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            intervals[i][0] = Integer.parseInt(st.nextToken());
            intervals[i][1] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] newInterval = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());    
        for(int i = 0;i < m;i++){
            newInterval[i] = Integer.parseInt(st.nextToken());
        }
        List<int[]> lst = new ArrayList<>();
        boolean added = false;
        for(int i = 0;i < intervals.length;i++){
            int[] cur = intervals[i];
            if(newInterval[0] < cur[0] && !added){
                lst.add(newInterval);
                added = true;
            }
            lst.add(cur);
        }
        List<int[]> result = new ArrayList<>();
        for(int i = 0;i < lst.size();i++){
            if(result.size() == 0){
                result.add(lst.get(i));
            } else {
                int[] cur = lst.get(i);
                int[] last = result.get(result.size() - 1);
                if(cur[0] > last[1]){
                    result.add(cur);
                } else {
                    last[1] = cur[1] > last[1] ? cur[1] : last[1];
                }
            }
        }
        for(int[] a : result){
            System.out.println(a[0] + " " + a[1]);
        }
        
    }
}
