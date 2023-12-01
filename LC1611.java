import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class LC1611 {
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int n = Integer.parseInt(br.readLine());
        // System.out.println(n);
        int sum = 0;
        int count = 0;
        while(n > 0){
            while((n & 1) != 1){
                count++;
                n = n >> 1;
            }
            n = n >> 1;
            count++;
            int v = (int)Math.pow(2, count) - 1;
            sum = v - sum;
        }
        System.out.println(sum);
    }

    static int helper(int n){
        if(n <= 1){
            return n;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        int p = (int)Math.floor(Math.log(n) / Math.log(2));
        int l = (int)Math.pow(2, p);
        int r = n - l;
        int count = 1;
        for(int i = 0;i < Integer.toBinaryString(n).length();i++){
            count *= 2;
        }
        count -= 1;
        count -= helper(r);
        map.put(n, count);
        return count;
    }
    
}

// public class LC1611 {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new FileReader("input.txt"));

//         int n = Integer.parseInt(br.readLine());
//         char[] arr = Integer.toBinaryString(n).toCharArray();
//         int count = 0;
//         HashMap<String, HashMap<Integer, Count>> map = new HashMap<>();
//         for(int i = 0;i < arr.length;i++){
//             if(arr[i] == '1'){
//                 count += change(arr, '0', i, map);
//             }   
//         }
//         System.out.println(count);
//     }
//     static class Count{
//         String s;
//         int c;
//         Count(String s, int c){
//             this.s = s;
//             this.c = c;
//         }
//     }
//     static int change(char[] arr, char target, int pos, HashMap<String, HashMap<Integer, Count>> map){
//         if(arr[pos] == target){
//             return 0;
//         }
//         if(pos == arr.length - 1){
//             arr[pos] = target;
//             return 1;
//         }
//         char[] ori = Arrays.copyOfRange(arr, pos, arr.length);
//         String oris = new String(ori);
//         if(map.containsKey(oris) && map.get(oris).containsKey(target - '0')){
//             String s = map.get(oris).get(target - '0').s;
//             int p = 0;
//             for(int i = pos;i < arr.length;i++){
//                 arr[i] = s.charAt(p);
//                 p++;
//             }
            
//             return map.get(oris).get(target - '0').c;
//         }
        
//         int count = 1;
//         count += change(arr, '1', pos + 1, map);
//         for(int i = pos + 2;i < arr.length;i++){
//             count += change(arr, '0', i, map);
//         }
//         arr[pos] = target;
//         char[] sub = Arrays.copyOfRange(arr, pos, arr.length);
//         Count c = new Count(new String(sub), count);
//         if(!map.containsKey(oris)){
//             HashMap<Integer, Count> m = new HashMap<>();
//             map.put(oris, m);
//         }
//         map.get(oris).put(target - '0', c);
//         return count;
//     }
// }
