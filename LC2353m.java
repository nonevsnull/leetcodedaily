import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class LC2353m {
    public static void main(String[] args) throws IOException {
        String[] foods = new String[]{"emgqdbo","jmvfxjohq","qnvseohnoe","yhptazyko","ocqmvmwjq"};
        String[] cuisines = new String[]{"snaxol","snaxol","snaxol","fajbervsj","fajbervsj"};
        int[] ratings = new int[]{2,6,18,6,5};

        FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
        obj.changeRating("qnvseohnoe",11);
        String param_2 = obj.highestRated("fajbervsj");
        System.out.println(param_2);
        obj.changeRating("emgqdbo",3);
        obj.changeRating("jmvfxjohq",9);
        obj.changeRating("emgqdbo",14);
        System.out.println(obj.highestRated("fajbervsj"));
        System.out.println(obj.highestRated("snaxol"));
    }


    static class FoodRatings {
        String[] foods; 
        String[] cuisines;
        int[] ratings;
        HashMap<String, TreeMap<Integer, List<String>>> map;
        HashMap<String, Integer> fmp;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            this.foods = foods;
            this.cuisines = cuisines;
            this.ratings = ratings;
            this.map = new HashMap<>();
            this.fmp = new HashMap<>();
            for(int i = 0;i < foods.length;i++){
                if(!map.containsKey(cuisines[i])){
                    TreeMap<Integer, List<String>> tmp = new TreeMap<>(Collections.reverseOrder());
                    map.put(cuisines[i], tmp);
                }
                TreeMap<Integer, List<String>> rf = map.get(cuisines[i]);
                if(!rf.containsKey(ratings[i])){
                    List<String> lst = new ArrayList<>();
                    rf.put(ratings[i], lst);
                }
                rf.get(ratings[i]).add(foods[i]);
                fmp.put(foods[i], i);
            }
        }
        
        public void changeRating(String food, int newRating) {
            int id = fmp.get(food);
            TreeMap<Integer, List<String>> rfs = map.get(cuisines[id]);
            List<String> lst = rfs.get(ratings[id]);
            lst.remove(food);

            if(lst.isEmpty()){
                rfs.remove(ratings[id]);
            }
            if(!rfs.containsKey(newRating)){
                List<String> l = new ArrayList<>();
                rfs.put(newRating, l);
            }
            List<String> lstn = rfs.get(newRating);
            lstn.add(food);

            ratings[id] = newRating;
        }
        
        public String highestRated(String cuisine) {
            TreeMap<Integer, List<String>> rfs = map.get(cuisine);
            List<String> lst = rfs.get(rfs.firstKey());
            Collections.sort(lst);
            return lst.get(0);
        }
    }
}
