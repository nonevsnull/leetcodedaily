import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class LC3m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        String s = br.readLine();

        HashMap<Character, Integer> map = new HashMap<>();

        int l = 0, max = 0;
        for(int i = 0;i < s.length();i++){
            char cur = s.charAt(i);

            while(map.containsKey(cur)){
                map.remove(s.charAt(l));
                l++;
            }
            map.put(cur, 1);
            max = Math.max(max, map.size());
        }
        System.out.println(max);

        
    }
}
