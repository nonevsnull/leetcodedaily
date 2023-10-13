import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 20231011
 * 
 * 
 */
public class LC2251h {
    static int binarySearch(List<int[]> buckets, int people) {
        int left = 0, right = buckets.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int[] flower = buckets.get(mid);
            if (people >= flower[0] && people <= flower[1]) {
                return flower[2];
            } else if (people < flower[0]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }

    static List<int[]> bucketing(int[][] flowers) {
        // TreeMap<Integer, Integer> map = new TreeMap<>();
        // for(int i = 0;i < flowers.length;i++){
        //     int start = flowers[i][0];
        //     if(!map.containsKey(start)){
        //         map.put(start, 0);
        //     }
        //     map.put(start, map.get(start) + 1);
        //     int end = flowers[i][1] + 1;
        //     if(!map.containsKey(end)){
        //         map.put(end, 0);
        //     }
        //     map.put(end, map.get(end) - 1);
        // }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i = 0;i < flowers.length;i++) {
            int start = flowers[i][0];
            int end = flowers[i][1] + 1;
            int[] p = new int[]{start, 1};
            int[] q = new int[]{end, -1};
            pq.add(p);
            pq.add(q);
        }
        // for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        //     int[] item = new int[]{entry.getKey(), entry.getValue()};
        //     pq.add(item);
        // }

        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        List<int[]> buckets = new ArrayList<>();
        while(pq.size()>0){
            int[] left = pq.poll();
            int[] right = pq.peek();
            if(right == null) {
                break;
            }

            count += left[1];
            int[] bucket = new int[]{left[0], right[0] - 1, count};
            buckets.add(bucket);
        }
        return buckets;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[][] flowers = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            flowers[i][0] = Integer.parseInt(st.nextToken());
            flowers[i][1] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] people = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        List<int[]> bloomIntervals = bucketing(flowers);

        for (int i : people) {
            int r = binarySearch(bloomIntervals, i);
            System.out.println(r);
        }
    }
}
