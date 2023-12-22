class Solution {
    public int maxScore(String s) {
        int count1 = 0;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '1'){
                count1++;
            }
        }
        int max = 0;
        int left = 0;
        for(int i = 0;i < s.length() - 1;i++){
            if(s.charAt(i) == '0'){
                left++;
            } else {
                count1--;
            }
            max = Math.max(left + count1, max);
        }
        return max;
    }
}