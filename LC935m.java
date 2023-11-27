class Solution {
    public int knightDialer(int n) {
        int[][][] matrix = new int[4][3][n+1];
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                if(!(i == 3 && j == 0) && !(i == 3 && j == 2)){
                    matrix[i][j][1] = 1;
                }
            }
        }
        for(int k = 2;k < matrix[0][0].length;k++){
            for(int i = 0;i < matrix.length;i++){
                for(int j = 0;j < matrix[0].length;j++){
                    if((i == 3 && j == 0) || (i == 3 && j == 2)){
                        continue;
                    }

                    if(j + 2 < matrix[0].length){
                        if(i - 1 >= 0){
                            matrix[i][j][k] += matrix[i - 1][j + 2][k - 1];
                            matrix[i][j][k] %= 1000000007;
                        }
                        if(i + 1 < matrix.length){
                            matrix[i][j][k] += matrix[i + 1][j + 2][k - 1];
                            matrix[i][j][k] %= 1000000007;
                        }
                    }
                    if(j - 2 >= 0){
                        if(i - 1 >= 0){
                            matrix[i][j][k] += matrix[i - 1][j - 2][k - 1];
                            matrix[i][j][k] %= 1000000007;
                        }
                        if(i + 1 < matrix.length){
                            matrix[i][j][k] += matrix[i + 1][j - 2][k - 1];
                            matrix[i][j][k] %= 1000000007;
                        }
                    }
                    if(i - 2 >= 0){
                        if(j - 1 >= 0){
                            matrix[i][j][k] += matrix[i - 2][j - 1][k - 1];
                            matrix[i][j][k] %= 1000000007;
                        }
                        if(j + 1 < matrix[0].length){
                            matrix[i][j][k] += matrix[i - 2][j + 1][k - 1];
                            matrix[i][j][k] %= 1000000007;
                        }
                    }
                    if(i + 2 < matrix.length){
                        if(j - 1 >= 0){
                            matrix[i][j][k] += matrix[i + 2][j - 1][k - 1];
                            matrix[i][j][k] %= 1000000007;
                        }
                        if(j + 1 < matrix[0].length){
                            matrix[i][j][k] += matrix[i + 2][j + 1][k - 1];
                            matrix[i][j][k] %= 1000000007;
                        }
                    }
                    
                }
            }      
        }
        int total = 0;
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                if(!(i == 3 && j == 0) && !(i == 3 && j == 2)){
                    total += matrix[i][j][n];
                    total %= 1000000007;
                }
            }
        }
        return total;
        
    }
}

// class Solution {
//     static long[][][] map;
//     public int knightDialer(int n) {
//         int[][] arr = new int[4][3];
//         long sum = 0;
//         map = new long[4][3][n + 1];
//         for(int i = 0;i < arr.length;i++){
//             for(int j = 0;j < arr[0].length;j++){
//                 if(!(i == 3 && j == 0) && !(i == 3 && j == 2) ){
//                     int[] cur = new int[]{i, j};
//                     List<Integer> counts = new ArrayList<>();
//                     // System.out.println("start: " + cur[0] + " " +cur[1]);
//                     long total = helper(arr, cur, 1, n);
//                     sum = (sum + total) % 1000000007;
//                 }
//             }
//         }
//         return (int)sum;
//     }

//     static long helper(int[][] arr, int[] cur, int len, int n){ 
//         long total = 0;  
//         if(cur[0] == 3 && (cur[1] == 0 || cur[1] == 2)){
//             return 0;
//         }
//         if(map[cur[0]][cur[1]][len] != 0){
//             // System.out.println(cur);
//             return map[cur[0]][cur[1]][len];
//         }
//         if(len == n){
//             // System.out.println(cur[0] + " " +cur[1]);
//             return 1;
//         }
        
//         if(cur[1] + 2 < arr[0].length){
//             if(cur[0] - 1 >= 0){
//                 total += (helper(arr, new int[]{cur[0] - 1, cur[1] + 2}, len + 1, n)) % 1000000007;
//             }
//             if(cur[0] + 1 < arr.length){
//                 total += (helper(arr, new int[]{cur[0] + 1, cur[1] + 2}, len + 1, n))% 1000000007;
//             }
//         }
//         if(cur[1] - 2 >= 0){
//             if(cur[0] - 1 >= 0){
//                 total += (helper(arr, new int[]{cur[0] - 1, cur[1] - 2}, len + 1, n))% 1000000007;
//             }
//             if(cur[0] + 1 < arr.length){
//                 total += (helper(arr, new int[]{cur[0] + 1, cur[1] - 2}, len + 1, n))% 1000000007;
//             }
//         }
//         if(cur[0] + 2 < arr.length){
//             if(cur[1] - 1 >= 0){
//                 total += (helper(arr, new int[]{cur[0] + 2, cur[1] - 1}, len + 1, n))% 1000000007;
//             }
//             if(cur[1] + 1 < arr[0].length){
//                 total += (helper(arr, new int[]{cur[0] + 2, cur[1] + 1}, len + 1, n))% 1000000007;
//             }
//         }
//         if(cur[0] - 2 >= 0){
//             if(cur[1] - 1 >= 0){
//                 total += (helper(arr, new int[]{cur[0] - 2, cur[1] - 1}, len + 1, n))% 1000000007;
//             }
//             if(cur[1] + 1 < arr[0].length){
//                 total += (helper(arr, new int[]{cur[0] - 2, cur[1] + 1}, len + 1, n))% 1000000007;
//             }
//         }

//         map[cur[0]][cur[1]][len] = total;
//         return total;
//     }
// }