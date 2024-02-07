import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LC12m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int num = Integer.parseInt(br.readLine());

        TreeMap<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        
        StringBuilder sb = new StringBuilder();

        for(Map.Entry<Integer, String> e : map.entrySet()){
            int n = e.getKey();
            String rom = e.getValue();

            int count = num / n;
            num = num - count * n;
            sb.append(rom.repeat(count));
        }
        System.out.println(sb.toString());
    }
}
