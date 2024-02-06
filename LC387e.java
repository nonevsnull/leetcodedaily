import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LC387e {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        String s = br.readLine();

        int[] arr = new int[26];
        for(int i = 0;i < s.length();i++){
            char cur = s.charAt(i);

            arr[cur - 'a']++;
        }
        for(int i = 0;i < s.length();i++){
            char cur = s.charAt(i);
            if(arr[cur - 'a'] == 1){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);

    }
}
