class Solution {
    public int totalMoney(int n) {
        int sum = 0;
        int multiple = n / 7;
        for(int i = 0;i < multiple;i++){
            sum += (1 + 7) * 7 / 2 + i * 7;
        }
        for(int i = 1;i <= n % 7;i++){
            sum += i;
        }
        sum += (n % 7) * multiple;

        return sum;
    }
}