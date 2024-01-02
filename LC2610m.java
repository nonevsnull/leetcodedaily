class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        List<List<Integer>> lst = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            int num = nums[i];
            if(map.containsKey(num)){
                int r = map.get(num);
                if(r < lst.size() - 1){
                    lst.get(r + 1).add(num);
                    map.put(num, r + 1);
                } else {
                    List<Integer> nr = new ArrayList<>();
                    nr.add(num);
                    lst.add(nr);
                    map.put(num, lst.size() - 1);
                }
            } else {
                if(lst.size() == 0){
                    List<Integer> nr = new ArrayList<>();
                    lst.add(nr);
                }
                lst.get(0).add(num);
                map.put(num, 0);
            }
        }
        return lst;
    }
}