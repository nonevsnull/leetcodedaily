class Solution {
    //HashMap<Integer, List<Integer>>
    //HashSet<Integer> visited
    //scan to build map
    //scan to find head
    //build from head, find the neighbor of head
    //check the neighbors of the item, find the un-visited
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        HashSet<Integer> visited = new HashSet<>();

        for(int i = 0;i < adjacentPairs.length;i++){
            int[] neighbors = adjacentPairs[i];
            if(!map.containsKey(neighbors[0])){
                List<Integer> lst = new ArrayList<>();
                map.put(neighbors[0], lst);
            }
            map.get(neighbors[0]).add(neighbors[1]);

            if(!map.containsKey(neighbors[1])){
                List<Integer> lst = new ArrayList<>();
                map.put(neighbors[1], lst);
            }
            map.get(neighbors[1]).add(neighbors[0]);
        }
        int head = 0;
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            if(entry.getValue().size() == 1){
                head = entry.getKey();
                break;
            }
        }
        int[] result = new int[adjacentPairs.length + 1];
        result[0] = head;
        visited.add(head);
        int pos = 1;
        while(pos < adjacentPairs.length + 1){
            List<Integer> neighbors = map.get(head);
            int next = neighbors.get(0);
            if(neighbors.size() > 1 && visited.contains(next)){
                next = neighbors.get(1);
            }
            visited.add(next);
            result[pos] = next;
            head = next;
            pos++;
        }
        return result;
    }
}