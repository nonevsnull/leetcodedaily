import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC1239m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());

        List<String> arr = new ArrayList<>();

        for(int i = 0;i < n;i++){
            arr.add(br.readLine());
        }
        br.close();
        int max = 0;
        int upper = (int)Math.pow(2, arr.size());
        for(int i = 0;i < upper;i++){
            String ind = String.format("%" + arr.size() + "s", Integer.toBinaryString(i)).replace(' ', '0');
            HashSet<Character> set = new HashSet<>();
            boolean found = true;
            
            for(int j = 0;j < ind.length();j++){
                if(ind.charAt(j) == '1'){
                    String str = arr.get(j);
                    for(int k = 0;k < str.length();k++){
                        if(set.contains(str.charAt(k))){
                            found = false;
                            break;
                        } else {
                            set.add(str.charAt(k));
                        }
                    }
                    if(!found){
                        break;
                    }
                }
            }
            if(found){
                max = Math.max(max, set.size());
            }
        }
        System.out.println(max);
    }
}
