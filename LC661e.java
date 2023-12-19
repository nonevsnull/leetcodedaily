class Solution {
    public int[][] imageSmoother(int[][] img) {
        int[][] smt = new int[img.length][img[0].length];

        for(int i = 0;i < img.length;i++){
            for(int j = 0;j < img[0].length;j++){
                double v = 0;
                int count = 0;
                if(i - 1 >= 0 && j - 1 >= 0){
                    v += img[i - 1][j - 1];
                    count++;
                }
                if(i - 1 >= 0){
                    v += img[i - 1][j];
                    count++;
                }
                if(i - 1 >= 0 && j + 1 < img[0].length){
                    v += img[i - 1][j + 1];
                    count++;
                }
                if(j + 1 < img[0].length){
                    v += img[i][j + 1];
                    count++;
                }
                if(i + 1 < img.length && j + 1 < img[0].length){
                    v += img[i + 1][j + 1];
                    count++;
                }
                if(i + 1 < img.length){
                    v += img[i + 1][j];
                    count++;
                }
                if(i + 1 < img.length && j - 1 >= 0){
                    v += img[i + 1][j - 1];
                    count++;
                }
                if(j - 1 >= 0){
                    v += img[i][j - 1];
                    count++;
                }
                v += img[i][j];
                count++;
                v /= count;
                v = Math.floor(v);
                smt[i][j] = (int)v;
            }
        }
        return smt;
    }
}