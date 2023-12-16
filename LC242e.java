class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] arrs = new int[26];
        int[] arrt = new int[26];
        for(int i = 0;i < s.length();i++){
            arrs[s.charAt(i) - 'a']++;
            arrt[t.charAt(i) - 'a']++;
        }
        for(int i = 0;i < arrs.length;i++){
            if(arrs[i] != arrt[i]){
                return false;
            }
        }
        return true;
    }
}