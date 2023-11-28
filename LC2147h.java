class Solution {
    public int numberOfWays(String corridor) {
        List<Integer> lst = new ArrayList<>();
        int start = corridor.indexOf("S");
        if(start < 0){
            return 0;
        }
        int end = corridor.lastIndexOf("S");
        String s = corridor.substring(start, end + 1);
        int scount = 0, tcount = 0;
        int pos = 0;
        while(pos < s.length()){
            while(pos < s.length() && scount < 2){
                if(pos < s.length() && s.charAt(pos) == 'S'){
                    scount++;
                } 
                pos++;
            }
            if(scount == 2){
                while(pos < s.length() && s.charAt(pos) == 'P'){
                    tcount++;
                    pos++;
                }
                scount = 0;
                // System.out.println(tcount + 1);
                lst.add(tcount+1);
                tcount = 0;
            } else {
                return 0;
            }
        }
        long sum = 1;
        for(int i : lst){
            sum *= i;
            sum %= 1000000007;
        }
        return (int)sum;
    }
}