class Solution {
    public int minCost(String colors, int[] neededTime) {
        int sum = 0;
        int max = 0;
        char pre = '1';
        int total = 0;

        for(int i = 0;i < colors.length();i++){
            if(pre == colors.charAt(i)){
                sum += neededTime[i];
                max = Math.max(max, neededTime[i]);
            } else {
                total += sum - max;
                sum = neededTime[i];
                max = neededTime[i];
            }
            pre = colors.charAt(i);
        }
        if(max != sum){
            total += sum - max;
        }
        return total;
    }
}