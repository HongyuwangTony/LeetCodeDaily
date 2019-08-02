import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Q341_FlattenNestedListIterator {

     // This is the interface that allows for creating nested lists.
     // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {

        private void flatten(NestedInteger ni, List<Integer> flatten_list) {
            if (ni.isInteger()) {
                flatten_list.add(ni.getInteger());
                return;
            }
            for (NestedInteger ni_inner : ni.getList()) {
                flatten(ni_inner, flatten_list);
            }
        }

        List<Integer> flatten_list;
        Iterator<Integer> it;

        public NestedIterator(List<NestedInteger> nestedList) {
            flatten_list = new ArrayList<>();
            for (NestedInteger ni : nestedList) {
                flatten(ni, flatten_list);
            }
            it = flatten_list.iterator();
        }

        @Override
        public Integer next() {
            return it.next();
        }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
