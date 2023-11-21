class Solution {
    public int countNicePairs(int[] nums) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            int a = nums[i];
            StringBuilder sb = new StringBuilder(Integer.toString(a));
            int ra = Integer.parseInt(sb.reverse().toString());
            if(!map.containsKey(a - ra)){
                map.put(a - ra, 0);
            }
            map.put(a - ra, map.get(a - ra) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            long c = entry.getValue();
            count = (int)((count + c * (c - 1) / 2) % 1000000007);
        }

        return (int)count;
    }
}