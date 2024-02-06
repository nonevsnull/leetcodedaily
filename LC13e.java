import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LC13e {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        String s = br.readLine();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int num = 0;
        int pos = 0;
        while(pos < s.length()){
            if(pos != s.length() - 1 && map.containsKey(s.subSequence(pos, pos + 2))){
                num += map.get(s.subSequence(pos, pos + 2));
                pos += 2;
            } else {
                num += map.get(s.substring(pos, pos + 1));
                pos++;
            }
        }
        System.out.println(num);
    
    }
}
