import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LC125e {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        String s = br.readLine();
        s = s.toLowerCase();

        int l = 0, r = s.length() - 1;
        while(l < r){
            char lc = s.charAt(l);
            char rc = s.charAt(r);
            if(!Character.isAlphabetic(lc) && !Character.isDigit(lc)){
                l++;
            } else if(!Character.isAlphabetic(rc) && !Character.isDigit(rc)){
                r--;
            } else if(lc != rc){
                System.out.println(false);
                return;
            } else {
                l++;
                r--;
            }
        }
        System.out.println(true);

    }
}
