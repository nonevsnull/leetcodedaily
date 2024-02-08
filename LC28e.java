import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LC28e {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        String haystack = br.readLine();
        String needle = br.readLine();

        System.out.println(haystack.indexOf(needle));

    }
}
