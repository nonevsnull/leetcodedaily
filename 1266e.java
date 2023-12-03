class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int sum = 0;
        for(int i = 0;i < points.length - 1;i++){
            int[] p0 = points[i];
            int[] p1 = points[i + 1];
            sum += Math.max(Math.abs(p0[0] - p1[0]), Math.abs(p0[1] - p1[1]));
        }
        return sum;
    }
}