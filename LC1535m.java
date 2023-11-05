class Solution {
    public int getWinner(int[] arr, int k) {
        Deque<Integer> dq = new LinkedList<>();
        for(int i = 0;i < arr.length;i++){
            dq.addLast(arr[i]);
        }

        int[] winner = new int[]{0, 0};

        k = Math.min(k, arr.length);

        while(winner[1] < k){
            int arr0 = dq.pollFirst();
            int arr1 = dq.pollFirst();
            if(arr0 > arr1){
                dq.addFirst(arr0);
                dq.addLast(arr1);
                if(arr0 == winner[0]){
                    winner[1]++;
                } else {
                    winner[0] = arr0;
                    winner[1] = 1;
                }
            } else {
                dq.addFirst(arr1);
                dq.addLast(arr0);
                if(arr1 == winner[0]){
                    winner[1]++;
                } else {
                    winner[0] = arr1;
                    winner[1] = 1;
                }
            }
        }
        return winner[0];
    }
}