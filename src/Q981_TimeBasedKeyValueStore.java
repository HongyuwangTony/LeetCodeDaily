import java.util.ArrayList;
import java.util.HashMap;

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

        HashMap<String, ArrayList<Value>> map;

        /** Initialize your data structure here. */
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(new Value(value, timestamp));
        }

        public String binarySearch(String key, int timestamp) {
            ArrayList<Value> list = map.get(key);
            int lo = 0, hi = list.size() - 1, res = -1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                int timestamp_mid = list.get(mid).timestamp;
                if (timestamp_mid == timestamp) {
                    res = mid;
                    break;
                } else if (timestamp_mid < timestamp) {
                    res = mid;
                    lo = mid + 1;
                } else hi = mid - 1;
            }
            return res == -1 ? "" : list.get(res).value;
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) return "";
            return binarySearch(key, timestamp);
        }
    }

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
}
