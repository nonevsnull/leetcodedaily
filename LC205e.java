import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class LC205e {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String s = br.readLine();
        String t = br.readLine();
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for(int i = 0;i < s.length();i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if(map.containsKey(cs)){
                cs = map.get(cs);
            } else {
                if(set.contains(ct)){
                    System.out.println(false);
                    return;
                }
                map.put(cs, ct);
                cs = ct;
                set.add(ct);
            }
            if(cs != ct){
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }
}
