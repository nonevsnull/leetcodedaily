class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0;i < nums.length;i++){
            int num = nums[i];
            if(!map.containsKey(num)){
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }

        int count = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            int c = e.getValue();
            // System.out.println(e.getKey() + " " + e.getValue());
            int[] p = find(c);
            if(p[0] < 0){
                return -1;
            }
            count += p[0] + p[1];
        }
        return count;
    }

    static int[] find(int n){
        int a = n / 3;
        
        while((n - 3 * a) % 2 != 0 && a >= 0){
            a--;
        }
        int b = (n - 3 * a) / 2;
        return new int[]{a, b};
    }
}