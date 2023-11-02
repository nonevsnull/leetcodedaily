import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LC2433m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[] pref = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i < n;i++){
            pref[i] = Integer.parseInt(st.nextToken());
        }


        int[] arr = new int[pref.length];
        arr[0] = pref[0];
        for(int i = 1;i < n;i++){
            arr[i] = pref[i] ^ pref[i - 1];
        }
        for(int i : arr){
            System.out.println(i);
        }
    
    }
}
