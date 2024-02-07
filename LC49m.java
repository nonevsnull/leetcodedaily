import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class LC49m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] strs = new String[n];
        for(int i = 0;i < n;i++){
            strs[i] = st.nextToken();
        }
        
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0;i < strs.length;i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String ns = new String(arr);
            if(!map.containsKey(ns)){
                List<String> lst = new ArrayList<>();
                map.put(ns, lst);
            }
            map.get(ns).add(strs[i]);
        }
        List<List<String>> lst = new ArrayList<>();
        for(Map.Entry<String, List<String>> e: map.entrySet()){
            lst.add(e.getValue());
        }
        for(List<String> ss : lst){
            System.out.println(ss);
        }

    }
}
