class Solution {
    public int minOperations(String s) {
        if(s.length() == 1){
            return 0;
        }
        int count1 = 0;
        char pre = '0';
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == pre){
                count1++;
                pre = s.charAt(i) == '0'? '1' : '0';
            } else {
                pre = s.charAt(i);
            }
        }
        int count2 = 0;
        pre = '1';
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == pre){
                count2++;
                pre = s.charAt(i) == '0'? '1' : '0';
            } else {
                pre = s.charAt(i);
            }
        }
        return Math.min(count1, count2);
    }
}