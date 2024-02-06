import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LC274m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[] citations = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i < n;i++){
            citations[i] = Integer.parseInt(st.nextToken());
        }

        //O(m + n)
        int[] arr = new int[1001];
        for(int i = 0;i < citations.length;i++){
            arr[citations[i]]++;
        }
        int max = 0;
        int total = citations.length;
        for(int i = 0;i < arr.length;i++){
            max = Math.max(max, Math.min(i, total));
            total -= arr[i];
        }
        System.out.println(max);

        // O(m log m)
        // Arrays.sort(citations);

        // int max = 0;
        // for(int i = 0;i < citations.length;i++){
        //     max = Math.max(max, Math.min(citations[i], citations.length - i)); 
        // }
        // System.out.println(max);


        //BF O(m * n)
    //     int max = 0;
    //     for(int i = 1000;i >= 0;i--){
    //         int count = 0;
    //         for(int j = 0;j < citations.length;j++){
    //             if(citations[j] >= i){
    //                 count++;
    //             }
    //         }
    //         if(count >= i){
    //             max = Math.max(max, i);
    //         }
    //     }
    //     System.out.println(max);
    }
}
