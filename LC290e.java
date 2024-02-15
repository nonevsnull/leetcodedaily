import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class LC290e {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String pattern = br.readLine();
        String s = br.readLine();

        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        char[] arr = pattern.toCharArray();
        String[] words = s.split(" ");
        if(arr.length != words.length){
            System.out.println(false);
            return;
        }

        for(int i = 0;i < arr.length;i++){
            if(map.containsKey(arr[i])){
                String expected = map.get(arr[i]);
                if(!expected.equals(words[i])){
                    System.out.println(false);
                    return;
                }
            } else {
                if(set.contains(words[i])){
                    System.out.println(false);
                    return;
                }
                map.put(arr[i], words[i]);
                set.add(words[i]);
            }
        }
        System.out.println(true);

        
    }
}
