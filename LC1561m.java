class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int l = 0, r = piles.length - 1;
        int sum = 0;
        while(l < r){
            l++;
            r--;
            sum += piles[r];
            r--;
        }
        return sum;
    }
}