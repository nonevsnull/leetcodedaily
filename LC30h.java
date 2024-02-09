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

public class LC30h {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i < n;i++){
            words[i] = st.nextToken();
        }
        int size = words[0].length();
        int totalsize = size * words.length;
        HashMap<String, Integer> map = new HashMap<>();
        for(String w : words){
            if(!map.containsKey(w)){
                map.put(w, 0);
            }
            map.put(w, map.get(w) + 1);
        }
        List<Integer> lst = new ArrayList<>();
        for(int i = 0;i < s.length();i++){
            HashMap<String, Integer> cmap = new HashMap<>(map);
            if(i + totalsize <= s.length() && match(s.substring(i, i + totalsize),cmap, size)){
                lst.add(i);
            }
        }
        System.out.println(lst);

        
    }

    static boolean match(String s, HashMap<String, Integer> map, int size){
        
        int l = 0, r = l + size;
        while(r <= s.length()){
            String word = s.substring(l, r);
            if(map.containsKey(word)){
                map.put(word, map.get(word) - 1);
                if(map.get(word) == 0){
                    map.remove(word);
                }
            } else {
                return false;
            }
            l += size;
            r += size;
        }
        return true;
    }
}
