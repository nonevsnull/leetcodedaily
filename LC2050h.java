import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class LC2050h {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] relations = new int[m][2];
        for(int i = 0;i < m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relations[i] = new int[]{a, b};
        }
        int[] time = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i < n;i++){
            time[i] = Integer.parseInt(st.nextToken());
        }

        List<int[]> lst = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0;i < relations.length;i++){
            lst.add(relations[i]);
        }
        for(int i = 0;i < n;i++){
            set.add(i + 1);
        }

        int count = 0;

        if(relations.length == 0){
            for(int i : time){
                count = Math.max(i, count);
            }
            System.out.println(count);
            return;
        }
        

        while(lst.size() > 0){
            int max = 0;
            int[] arr = new int[n + 1];
            for(int i = 0;i < lst.size();i++){
                int[] cur = lst.get(i);
                arr[cur[1]]++;
            }

            for(int i = 0;i < n;i++){
                if(arr[i + 1] == 0 && time[i] != -1){
                    max = Math.max(max, time[i]);
                    time[i] = -1;
                    set.remove(i + 1);
                }
            }
            count += max;

            for(int i = 0;i < lst.size();i++){
                int[] cur = lst.get(i);
                if(!set.contains(cur[0])){
                    lst.remove(i);
                }
            }
        }
        if(set.iterator().hasNext()){
            count += time[set.iterator().next() - 1];
        }
        
        System.out.println(count);

    }
}