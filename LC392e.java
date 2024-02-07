import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LC392e {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        String s = br.readLine();
        String t = br.readLine();
        if(s.length() > t.length()){
            System.out.println(false);
            return;
        }
        int ps = 0;
        int pt = 0;

        while(ps < s.length() && pt < t.length()){
            if(s.charAt(ps) != t.charAt(pt)){
                pt++;
            } else {
                pt++;
                ps++;
            }
        }
        System.out.println(ps == s.length());

    }
}
