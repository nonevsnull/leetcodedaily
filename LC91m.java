class Solution {
    public int numDecodings(String s) {
        
        int count = 0;
        int[] arr = new int[s.length()];
        arr[0] = s.charAt(0) == '0'? 0 : 1;
        if(s.length() == 1){
            return arr[0];
        }
        if(s.charAt(1) == '0'){
            arr[1] = Integer.parseInt(s.substring(0, 2)) > 26 || s.charAt(0) == '0' ? 0 : arr[0];
        } else {
            arr[1] = Integer.parseInt(s.substring(0, 2)) > 26 || s.charAt(0) == '0' ? arr[0] : arr[0] + 1;
        }
        // arr[1] = Integer.parseInt(s.substring(0, 2)) > 26 || s.charAt(0) == '0' ? 0 : 1 + 1;
        for(int i = 2;i < s.length();i++){
            int v2 = Integer.parseInt(s.substring(i - 1, i + 1)) > 26 || s.charAt(i - 1) == '0' ? 0 : arr[i - 2];
            int v1 = s.charAt(i) == '0'? 0 : arr[i - 1];
            arr[i] = v1 + v2;
        }
        return arr[s.length() - 1];
    }
    // 1 1 1 0 6
    // [1, 2, 1 + 2, 2 + 3, 2 + 3]
    // 1,1,1,0,6
    // 11,1,0,6
    // 1,11,0,6
    // 1,1,10,6
    // 11,10,6

}