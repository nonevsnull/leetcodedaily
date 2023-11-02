import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class LC1356e {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i < n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Integer[] integerArray = Arrays.stream(arr)
            .boxed()
            .toArray(Integer[]::new);
        Arrays.sort(integerArray, new BinaryComparator());
        int[] intArray = Arrays.stream(integerArray)
            .mapToInt(Integer::intValue)
            .toArray();
        for(int i : intArray){
            System.out.println(i);
        }
    }
}

class BinaryComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer i1, Integer i2) {
        if(countOne(i1) > countOne(i2))
    }
    private int countOne(Integer i){
        int count = 0;
        while(i != 0){
            if((i & 1) == 1){
                count++;
            }
            i >>= 1;
        }
    }
    // public int compare(Integer i1, Integer i2){
    //     String b1 = Integer.toBinaryString(i1);
    //     String b2 = Integer.toBinaryString(i2);

    //     if(countOne(b1) > countOne(b2)){
    //         return 1;
    //     } else if(countOne(b1) == countOne(b2)) {
    //         return i1 > i2?1 : -1;
    //     } else {
    //         return -1;
    //     }

    // }

    // private int countOne(String s) {
    //     int count = 0;
    //     for(int i = 0;i < s.length();i++){
    //         if(s.charAt(i) == '1'){
    //             count++;
    //         }
    //     }
    //     return count;
    // }
}