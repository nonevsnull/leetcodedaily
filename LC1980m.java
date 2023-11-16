class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int[] arr = new int[(int)Math.pow(2,16)];
        Arrays.fill(arr, -1);
        for(int i = 0;i < nums.length;i++){
            int num = Integer.parseInt(nums[i], 2);
            arr[num] = 1;
        }
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == -1){
                String v = Integer.toBinaryString(i);
                return "0".repeat(nums.length - v.length()) + v;
            }
        }
        return "";
    }
}