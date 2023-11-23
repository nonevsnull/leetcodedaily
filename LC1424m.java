class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> lst = new ArrayList<>();

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        while(!q.isEmpty()){
            int[] pos = q.poll();
            if(pos[0] < nums.size()){
                List<Integer> row = nums.get(pos[0]);
                if(pos[1] < row.size()){
                    int v = row.get(pos[1]);
                    if(v != -1){
                        lst.add(v);
                        row.remove(pos[1]);
                        row.add(pos[1], -1);
                        q.add(new int[]{pos[0] + 1, pos[1]});
                        q.add(new int[]{pos[0], pos[1] + 1});
                    }
                }
            }
        } 
        int[] r = new int[lst.size()];
        for(int i = 0;i < lst.size();i++){
            r[i] = lst.get(i);
        }
        return r;

    }
}