class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        //p, g, m
        int[] dis = new int[3];
        int[] cs = new int[3];
        int locdis = 0;
        for(int i = 0;i < garbage.length;i++){
            boolean[] exists = counts(garbage[i].toCharArray(), cs);
            if(i > 0){
                locdis += travel[i - 1];
            }
            for(int j = 0;j < exists.length;j++){
                if(exists[j]){
                    dis[j] = locdis;
                }
            }
        }
        int r = 0;
        for(int i = 0;i < dis.length;i++){
            r += dis[i] + cs[i];
        }
        return r;
    }

    static boolean[] counts(char[] arr, int[] cs){
        boolean[] exists = new boolean[3];
        for(char c : arr){
            if(c == 'P'){
                cs[0]++;
                exists[0] = true;
            } else if(c == 'G') {
                cs[1]++;
                exists[1] = true;
            } else {
                cs[2]++;
                exists[2] = true;
            }
        }
        return exists;
    }
}