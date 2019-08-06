import java.util.ArrayList;
import java.util.List;

public class Q364_NestedListWeightSumII {
    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {
        // Constructor initializes an empty nested list.
        // public NestedInteger();

        // Constructor initializes a single integer.
        // public NestedInteger(int value);

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    static class Solution {
        // Referring to https://leetcode.com/problems/nested-list-weight-sum-ii/discuss/83641/No-depth-variable-no-multiplication
        public int depthSumInverse(List<NestedInteger> nestedList) {
            int prev = 0, curr = 0;
            while (!nestedList.isEmpty()) {
                List<NestedInteger> nextLevel = new ArrayList<>();
                for (NestedInteger ni : nestedList) {
                    if (ni.isInteger()) prev += ni.getInteger();
                    else nextLevel.addAll(ni.getList());
                }
                curr += prev;
                nestedList = nextLevel;
            }
            return curr;
        }
    }
}
