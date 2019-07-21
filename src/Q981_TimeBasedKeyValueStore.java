import java.util.*;

public class Q981_TimeBasedKeyValueStore {
    class TimeMap {
        HashMap<String, TreeMap<Integer, String>> map;

        /** Initialize your data structure here. */
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)) {
                map.put(key, new TreeMap<>());
            }
            map.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            Map.Entry<Integer, String> entry;
            if (!map.containsKey(key)) return "";
            else if ((entry = map.get(key).floorEntry(timestamp)) == null) return "";
            else return entry.getValue();
        }
    }

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
}
