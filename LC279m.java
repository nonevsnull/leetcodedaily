import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LC279m {
    static HashMap<Integer, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        map.put(0, 0);
        int r = helper(n);
        System.out.println(r);
    }

    static int helper(int n){
        if(map.containsKey(n)){
            return map.get(n);
        }

        int base = (int)Math.sqrt(n);
        int min = Integer.MAX_VALUE;
        for(int i = base;i >= 1;i--){
            min = Math.min(1 + helper(n - i * i), min);
        }
        map.put(n, min);
        return min;
    }
}
