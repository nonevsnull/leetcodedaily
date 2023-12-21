class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int w = 0;
        for(int i = 0;i < points.length - 1;i++){
            w = Math.max(w, points[i + 1][0] - points[i][0]);
        }
        return w;
    }
}