import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class Q380_InsertDeleteGetRandomO1 {
    static class RandomizedSet {
        private HashMap<Integer, Integer> map_val;
        private ArrayList<Integer> arr;
        private int count;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            map_val = new HashMap<>();
            arr = new ArrayList<>();
            count = 0;
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map_val.containsKey(val)) return false;
            map_val.put(val, count);
            arr.add(val);
            count++;
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!map_val.containsKey(val)) return false;
            int seq = map_val.remove(val);
            if (seq == count - 1) {
                arr.remove(seq);
            } else {
                int val_tail = arr.remove(count - 1);
                arr.set(seq, val_tail);
                map_val.put(val_tail, seq);
            }
            count--;
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return arr.get(new Random().nextInt(count));
        }
    }

    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
}
