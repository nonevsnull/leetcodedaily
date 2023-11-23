class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> lst = new ArrayList<>();
        for(int i = 0;i < l.length;i++){
            
            lst.add(check(Arrays.copyOfRange(nums, l[i], r[i] + 1)));
        }
        return lst;
    }

    static boolean check(int[] nums){
        Arrays.sort(nums);
        for(int i = 0;i < nums.length - 1;i++){
            if(nums[1] - nums[0] != nums[i + 1] - nums[i]){
                return false;
            }
        }
        return true;
    }
}