import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/*
 * 20231012
 */
public class LC1095h {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i < n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());
        int centre = findCentre(arr);
        int r = binarySearch(arr, 0, centre, target, 1);
        if(r == -1){
            r = binarySearch(arr, centre + 1, arr.length - 1, target, -1);
        }
        System.out.println(r);
    }

    static int findCentre(int[] arr) {
        int left = 0, right = arr.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] < arr[mid + 1]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    static int binarySearch(int[] arr, int left, int right, int target, int up){
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] * up < target * up){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
