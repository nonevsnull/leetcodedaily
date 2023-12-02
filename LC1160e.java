class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : chars.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        int count = 0;
        for(String s : words){
            HashMap<Character, Integer> mapi = new HashMap<>(map);
            boolean found = true;
            for(char c : s.toCharArray()){
                if(mapi.containsKey(c)){
                    mapi.put(c, mapi.get(c) - 1);
                    if(mapi.get(c) < 0){
                        found = false;
                        break;
                    }
                } else {
                    found = false;
                    break;
                }
            }
            if(found){
                count += s.length();
            }
        }
        return count;
    }
}