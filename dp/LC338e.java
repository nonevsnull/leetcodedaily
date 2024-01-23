package dp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LC338e {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        if(n == 0){
            printarr(arr);
        }
        arr[1] = 1;
        if(n == 1){
            printarr(arr);
        }
        arr[2] = 1;
        int base = 2;
        for(int i = 3;i < arr.length;i++){
            if(Math.ceil(Math.log(i) / Math.log(2)) == Math.floor(Math.log(i) / Math.log(2))){
                base = i;
            }
            int diff = i - base;
            arr[i] = 1 + arr[diff];
        }
        printarr(arr);
    }

    static void printarr(int[] arr){
        for(int i : arr){
            System.out.print(i + ",");
        }
        System.out.println("");
    }
}
