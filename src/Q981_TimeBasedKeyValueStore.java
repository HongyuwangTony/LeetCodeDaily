import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

public class Q981_TimeBasedKeyValueStore {
    class TimeMap {
        class Value {
            public Value(String value, int timestamp) {
                this.value = value;
                this.timestamp = timestamp;
            }

            String value;
            int timestamp;
        }

        HashMap<String, TreeSet<Value>> map;

        /** Initialize your data structure here. */
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (map.containsKey(key)) {
                map.get(key).add(new Value(value, timestamp));
            } else {
                TreeSet<Value> set = new TreeSet<>(new Comparator<Value>() {
                    @Override
                    public int compare(Value o1, Value o2) {
                        return o1.timestamp - o2.timestamp;
                    }
                });
                set.add(new Value(value, timestamp));
                map.put(key, set);
            }
        }

        public String get(String key, int timestamp) {
            if (map.containsKey(key)) {
                Value v = map.get(key).floor(new Value("", timestamp));
                return v == null ? "" : v.value;
            } else {
                return "";
            }
        }
    }

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
}
