class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target){
            return 0;
        }
        // System.out.println(routes.length);
        HashMap<Integer, HashSet<Integer>> stop_routes =  new HashMap<>();
        HashMap<Integer, HashSet<Integer>> route_stops =  new HashMap<>();
        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> cur_routes = new ArrayList<>();
        for(int i = 0;i < routes.length;i++){
            for(int j = 0;j < routes[i].length;j++){
                if(!stop_routes.containsKey(routes[i][j])){
                    HashSet<Integer> set = new HashSet<>();
                    stop_routes.put(routes[i][j], set);
                }
                stop_routes.get(routes[i][j]).add(i);
                if(routes[i][j] == source && !q.contains(i)) {
                    cur_routes.add(i);
                }
                if(!route_stops.containsKey(i)){
                    HashSet<Integer> set = new HashSet<>();
                    route_stops.put(i, set);
                }
                route_stops.get(i).add(routes[i][j]);
            }
        }
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> visitedS = new HashSet<>();
        int count = 0;

        q.add(cur_routes);
        while(!q.isEmpty()){
            count++;
            // System.out.println("q: " + q.size());
            List<Integer> cur = q.poll();
            List<Integer> next = new ArrayList<>();
            for(int route : cur){
                // visited.add(route);
                
                HashSet<Integer> stops = route_stops.get(route);
                // if(route == 498){
                //     System.out.println(count);
                //     System.out.println(stops);
                // }
                if(stops.contains(target)){
                    return count;
                } else {
                    
                    for(int stop : stops){
                        if(visitedS.contains(stop)){
                            continue;
                        }
                        visitedS.add(stop);
                        HashSet<Integer> rs = stop_routes.get(stop);
                        // if(stop == 2){
                        //     System.out.println(rs.contains(498));
                        // }
                        for(int r : rs){
                            if(!visited.contains(r)){
                                visited.add(r);
                                next.add(r);
                            }
                        }
                    }
                }
            } 
            if(!next.isEmpty()){
                q.add(next);
            }
            
        }
        return -1;
    }
}