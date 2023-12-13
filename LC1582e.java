class Solution {
    public int numSpecial(int[][] mat) {
        int sum = 0;
        for(int i = 0;i < mat.length;i++){
            for(int j = 0;j < mat[0].length;j++){
                if(mat[i][j] == 1){
                    if(check(mat, i, j)){
                        sum++;
                    }
                     
                    break;
                }
            }
        }
        return sum;  
    }
    static boolean check(int[][] mat, int x, int y){
        for(int i = 0;i < mat[0].length;i++){
            if(mat[x][i] == 1 && i != y){
                return false;
            }
        }
        for(int i = 0;i < mat.length;i++){
            if(mat[i][y] == 1 && i != x){
                return false;
            }
        }
        return true;
    }
}