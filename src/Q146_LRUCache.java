import java.util.*;

public class Q146_LRUCache {
    static class LRUCache {
        LinkedHashMap<Integer, Integer> map;
        int capacity;
        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new LinkedHashMap<>(capacity, 0.75F, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> e) {
                    return size() > capacity;
                }
            };
        }

        public int get(int key) {
            return this.map.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            this.map.put(key, value);
        }
    }

    public static List<List<Integer>> inputs_args_to_array(String inputs_args) {
        List<List<Integer>> ret = new ArrayList<>();
        for (String args : inputs_args.split("]")) {
            args = args.substring(args.indexOf("[") + 1);
            int index = args.indexOf(",");
            if (index == -1) { // One arg
                ret.add(List.of(Integer.valueOf(args)));
            } else { // Two args
                ret.add(List.of(Integer.valueOf(args.substring(0, index)),
                            Integer.valueOf(args.substring(index + 1))));
            }
        }
        return ret;
    }

    public static void test(List<String> inputs_func, List<List<Integer>> inputs_args, Integer[] expectedOutput) {
        System.out.println("Test Case " + testNum++ + ":");
        System.out.println("Input:");
        System.out.println(inputs_func.toString());
        System.out.println(inputs_args.toString());

        Integer[] result = new Integer[expectedOutput.length];
        LRUCache lruCache = new LRUCache(inputs_args.get(0).get(0));
        for (int i = 1; i < inputs_func.size(); i++) {
            String input_func = inputs_func.get(i);
            List<Integer> input_args = inputs_args.get(i);
            switch (input_func) {
                case "get":
                    result[i] = lruCache.get(input_args.get(0));
                    System.out.println("Actual: " + result[i]);
                    System.out.println("Expected: " + expectedOutput[i]);
                    break;
                case "put":
                    lruCache.put(input_args.get(0), input_args.get(1));
                    break;
                default:
                    System.out.println("Wrong func name: " + input_func);
            }
            System.out.println();
        }

        System.out.println("Expected Output: " + Arrays.toString(expectedOutput));
        System.out.println("Actual Output: " + Arrays.toString(result));
        assert Arrays.equals(result, expectedOutput);
        System.out.println();
    }

    public static int testNum = 1;

    public static void main(String[] args) {
        test(List.of("LRUCache","get","put","get","put","put","get","get"),
             inputs_args_to_array("[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]"),
             new Integer[]{null,-1,null,-1,null,null,2,6});
        test(List.of("LRUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"),
             inputs_args_to_array("[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]"),
             new Integer[]{null,null,null,null,null,null,-1,null,19,17,null,-1,null,null,null,-1,null,-1,5,-1,12,null,null,3,5,5,null,null,1,null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,18,null,null,null,null,-1,null,null,18,null,null,-1,null,null,null,null,null,18,null,null,-1,null,4,29,30,null,12,-1,null,null,null,null,29,null,null,null,null,17,22,18,null,null,null,-1,null,null,null,20,null,null,null,-1,18,18,null,null,null,null,20,null,null,null,null,null,null,null});
    }
}
