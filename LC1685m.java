class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int sum = 0;
        for(int i = 1;i < nums.length;i++){
            sum += nums[i] - nums[0];
        }
        int[] diff = new int[nums.length];
        diff[0] = sum;
        for(int i = 1;i < nums.length;i++){
            int d = nums[i] - nums[i - 1];
            int l = i-1;
            int r = nums.length - 1 - i;
            diff[i] = diff[i - 1] + l * d - r * d;
        }
        return diff;
    }
}