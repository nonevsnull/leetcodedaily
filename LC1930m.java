class Solution {
 
    public int countPalindromicSubsequence(String s) {
        int count = 0;
        for(int i = 0;i < 26;i++){
            char c = (char)('a' + i);
            int l = s.indexOf(c), r = s.lastIndexOf(c);
            HashSet<Character> set = new HashSet<>();
            for(int k = l + 1;k < r;k++){
                set.add(s.charAt(k));
            }
            count += set.size();
        }       
        return count;
    }

}