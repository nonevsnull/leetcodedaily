import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LC451m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        String s = br.readLine();

        int[] arr = new int['z' - '0' + 1];
        for(int i = 0;i < s.length();i++){
            arr[s.charAt(i) - '0']++;
        }

        List<int[]> lst = new ArrayList<>();

        for(int i = 0;i < arr.length;i++){
            if(arr[i] != 0){
                lst.add(new int[]{arr[i], i});
            }
            
        }
        Collections.sort(lst, Comparator.comparingInt(ar -> -ar[0]));
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < lst.size();i++){
            String cur = Character.toString(lst.get(i)[1] + '0').repeat(lst.get(i)[0]);
            sb.append(cur);
        }
        System.out.println(sb.toString());
    }
}
