class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb0 = new StringBuilder();
        for(String s : word1){
            sb0.append(s);
        }
        StringBuilder sb1 = new StringBuilder();
        for(String s : word2){
            sb1.append(s);
        }
        return sb0.toString().equals(sb1.toString());
    }
}