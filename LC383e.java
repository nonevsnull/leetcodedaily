import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LC383e {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String ransomNote = br.readLine();
        String magazine = br.readLine();

        // HashMap<Character, Integer> map = new HashMap<>();
        // for(char c : magazine.toCharArray()){
        //     if(!map.containsKey(c)){
        //         map.put(c, 0);
        //     }
        //     map.put(c, map.get(c) + 1);
        // }

        // for(char c : ransomNote.toCharArray()){
        //     if(!map.containsKey(c)){
        //         System.out.println(false);
        //         return;
        //     } else {
        //         map.put(c, map.get(c) - 1);
        //         if(map.get(c) < 0){
        //             System.out.println(false);
        //             return;
        //         }
        //     }
        // }
        // System.out.println(true);
        //用arr更经济
        int[] arr = new int[26];
        for(char c : magazine.toCharArray()){
            arr[c - 'a']++;
        }
        for(char c : ransomNote.toCharArray()){
            arr[c - 'a']--;
            if(arr[c - 'a'] < 0){
                System.out.println(false);
            }
        }
        System.out.println(true);
    }
}
