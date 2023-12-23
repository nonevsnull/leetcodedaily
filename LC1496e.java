class Solution {
    public boolean isPathCrossing(String path) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("0,0", 1);
        int x = 0, y = 0;
        for(int i = 0;i < path.length();i++){
            if(path.charAt(i) == 'N'){
                y++;
            } else if(path.charAt(i) == 'E'){
                x++;
            } else if(path.charAt(i) == 'S'){
                y--;
            } else {
                x--;
            }
            if(map.containsKey(x + "," + y)){
                return true;
            } else {
                map.put(x + "," + y, 1);
            }
        }
        return false;
    }
}