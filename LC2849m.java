class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int dis = Math.max(Math.abs(sx - fx), Math.abs(sy - fy));
        if(t == 1 && dis == 0){
            return false;
        }

        return dis <= t;
    }
}