import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class LC1921m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int n = Integer.parseInt(br.readLine());
        int[] dist = new int[n];
        int[] speed = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i < n;i++){
            dist[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < n;i++){
            speed[i] = Integer.parseInt(st.nextToken());
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i = 0;i < dist.length;i++){
            int d = dist[i];
            int v = speed[i];
            int t = (int)Math.ceil(d * 1.0 / v);
            if(!map.containsKey(t)){
                map.put(t, 0);
            }
            map.put(t, map.get(t) + 1);
        }

        int weapon = 1;
        int cur = 0;
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int t = entry.getKey();
            int m = entry.getValue();
            weapon += t - cur - 1;
            cur = t;
            if(weapon >= m){
                count += m;
                weapon -= m - 1;
            } else {
                count += weapon;
                System.out.println(count);
            }
        }
        System.out.println(count);
    }
}
