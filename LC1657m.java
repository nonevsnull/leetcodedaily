import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LC1657m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String word1 = br.readLine();
        String word2 = br.readLine();

        if(word1.length() != word2.length()){
            System.out.println("No");
        }
        int[] carr1 = new int[26];
        HashMap<Integer, Integer> map1 = new HashMap<>();

        for(int i = 0;i < word1.length();i++){
            char c = word1.charAt(i);
            carr1[c - 'a']++;
        }
        for(int i = 0;i < carr1.length;i++){
            if(carr1[i] != 0){
                map1.put(carr1[i], map1.getOrDefault(carr1[i], 0) + 1);
            }
        }
        HashMap<Integer, Integer> map2 = new HashMap<>();
        int[] carr2 = new int[26];
        for(int i = 0;i < word2.length();i++){
            char c = word2.charAt(i);
            if(carr1[c - 'a'] == 0){
                System.out.println("No1");
            }
        }
        for(int i = 0;i < carr2.length;i++){
            if(carr2[i] != 0){
                map2.put(carr2[i], map2.getOrDefault(carr2[i], 0) + 1);
            }
        }
        for(Map.Entry<Integer, Integer> e : map1.entrySet()){
            int k = e.getKey();
            int v = e.getValue();

            if(!map2.containsKey(k) || map2.get(k) != v){
                System.out.println("No2");
            }
        }
        System.out.println("Yes");

    }
}
