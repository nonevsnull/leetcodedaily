import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class LC76h {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        String s = br.readLine();
        String t = br.readLine();
        if(s.length() < t.length()){
            System.out.println("");
        }
        boolean found = false;
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for(int i = 0;i < t.length();i++){
            char cur = t.charAt(i);
            if(!map.containsKey(cur)){
                map.put(cur, 0);
            }
            map.put(cur, map.get(cur) + 1);
            set.add(cur);
        }
        int l = 0, r = 0;
        String min = s;
        while(l < s.length() && l <= r){
            if(!set.isEmpty() && r < s.length()){
                char cur = s.charAt(r);
                //move right
                if(t.contains(Character.toString(cur))){
                    map.put(cur, map.get(cur) - 1);
                    if(map.get(cur) == 0){
                        set.remove(cur);
                    }
                }
                r++;
            } else {
                char cur = s.charAt(l);
                //move left
                if(t.contains(Character.toString(cur))){
                    map.put(cur, map.get(cur) + 1);
                    if(map.get(cur) > 0){
                        set.add(cur);
                    }
                }
                l++;
            }
            if(set.isEmpty() && min.length() >= r - l){
                found = true;
                min = s.substring(l, r);
                System.out.println(min);
            }
        }
        if(!found){
            System.out.println("");
        } else {
            System.out.println(min);
        }
        
    }
}
