class Solution {
    public String largestOddNumber(String num) {
        int pos = -1;
        for(int i = num.length() - 1;i >= 0;i--){
            if((num.charAt(i) - '0') % 2 != 0){
                pos = i;
                break;
            }
        }
        if(pos == -1){
            return "";
        } else {
            return num.substring(0, pos + 1);
        }
    }
}