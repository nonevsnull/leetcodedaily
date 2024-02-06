import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class LC380m {
    class RandomizedSet {
        HashMap<Integer, Integer> map;
        List<Integer> lst; 
        public RandomizedSet() {
            this.map = new HashMap<>();
            this.lst = new ArrayList<>();
        }
        
        public boolean insert(int val) {
            if(map.containsKey(val)){
                return false;
            } else {
                map.put(val, lst.size());
                lst.add(val);
                return true;
            }
        }
        
        public boolean remove(int val) {
            if(!map.containsKey(val)){
                return false;
            } else {
                int id = map.get(val);
                int last_id = lst.size() - 1;

                map.put(lst.get(last_id), id);
                map.remove(val);
                
                lst.set(id, lst.get(last_id));
                lst.remove(last_id);
                return true;
            }
        }
        
        public int getRandom() {
            Random r = new Random();
            int id = r.nextInt(lst.size());
            return lst.get(id);
        }
    }

    public static void main(String[] args) {

    }
}
