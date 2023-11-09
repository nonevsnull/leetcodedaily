class Solution {
    public int countHomogenous(String s) {
        int n = s.length();
        char last = '1';
        long count = 0L;
        int sum = 0;
        for(int i = 0;i < n;i++){
            char cur = s.charAt(i);
            if(last == cur){
                count++;
            } else {
                sum += (count + 1) * count / 2 % (1000000007);
                count = 1;
                last = cur;
            }
        }
        sum += (count + 1) * count / 2 % (1000000007);
        return sum;
    }
}