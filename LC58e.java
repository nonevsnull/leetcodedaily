import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LC58e {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        String s = br.readLine();
        
        //优化：O(n), O(1)
        int count = 0;
        boolean start = false;
        for(int i = s.length() - 1;i >= 0;i--){
            char cur = s.charAt(i);
            if(start){
                if(cur != ' '){
                    count++;
                } else{
                    break;
                }
            } else {
                if(cur != ' '){
                    start = true;
                    count++;
                }
            }
        }
        System.out.println(count);
        
        //BF O(n), O(n)
        // s = s.trim();
        // String[] arr = s.split(" ");
        // if(arr.length == 0){
        //     System.out.println(0);
        // } else {
        //     System.out.println(arr[arr.length - 1].length());
        // }
    }
}
