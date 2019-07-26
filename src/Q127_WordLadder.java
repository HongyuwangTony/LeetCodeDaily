import java.util.HashSet;
import java.util.List;

public class Q127_WordLadder {
    static class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            HashSet<String> beginSet = new HashSet<>(), endSet = new HashSet<>(),
                    wordSet = new HashSet<>(wordList), visited = new HashSet<>();
            if (!wordSet.contains(endWord)) return 0;
            int wordLen = beginWord.length(), res = 1;
            beginSet.add(beginWord);
            endSet.add(endWord);
            visited.add(beginWord);
            visited.add(endWord);
            while (!beginSet.isEmpty() && !endSet.isEmpty()) {
                if (beginSet.size() > endSet.size()) {
                    HashSet<String> temp = beginSet;
                    beginSet = endSet;
                    endSet = temp;
                }

                HashSet<String> nextBeginSet = new HashSet<>();
                for (String word : beginSet) {
                    char[] buffer = word.toCharArray();
                    for (int i = 0; i < wordLen; i++) {
                        for (char c = 'a'; c <= 'z'; c++) {
                            char old = buffer[i];
                            buffer[i] = c;
                            String transformed = String.valueOf(buffer);
                            if (endSet.contains(transformed)) return res + 1;
                            if (!visited.contains(transformed) && wordSet.contains(transformed)) {
                                visited.add(transformed);
                                nextBeginSet.add(transformed);
                            }
                            buffer[i] = old;
                        }
                    }
                }
                beginSet = nextBeginSet;
                res++;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().ladderLength("hit", "cog",
                List.of("hot","dot","dog","lot","log","cog")));
        System.out.println(new Solution().ladderLength("hit", "cog",
                List.of("hot","dot","dog","lot","log")));
    }
}
