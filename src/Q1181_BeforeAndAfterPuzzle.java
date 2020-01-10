import java.util.*;

public class Q1181_BeforeAndAfterPuzzle {
    static class Solution {
        public List<String> beforeAndAfterPuzzles(String[] phrases) {
            HashMap<String, HashSet<String>> headMap = new HashMap<>(), tailMap = new HashMap<>();
            HashMap<String, Boolean> duplicate = new HashMap<>();
            for (String p : phrases) {
                String[] words = p.split(" ");
                if (duplicate.containsKey(p)) duplicate.put(p, true);
                else {
                    headMap.computeIfAbsent(words[0], s -> new HashSet<>()).add(p);
                    tailMap.computeIfAbsent(words[words.length - 1], s -> new HashSet<>()).add(p);
                    duplicate.put(p, false);
                }
            }

            TreeSet<String> res = new TreeSet<>();
            for (String middle : tailMap.keySet()) {
                if (!headMap.containsKey(middle)) continue;
                for (String tail : headMap.get(middle))
                    for (String head : tailMap.get(middle))
                        if (!head.equals(tail) || duplicate.get(tail))
                            res.add(head + tail.substring(middle.length()));
            }

            return new ArrayList<>(res);
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().beforeAndAfterPuzzles(new String[]{"writing code","code rocks"}));
        System.out.println(new Solution().beforeAndAfterPuzzles(new String[]{"mission statement",
                "a quick bite to eat",
                "a chip off the old block",
                "chocolate bar",
                "mission impossible",
                "a man on a mission",
                "block party",
                "eat my words",
                "bar of soap"}));
        System.out.println(new Solution().beforeAndAfterPuzzles(new String[]{"a","b","a"}));
    }
}
