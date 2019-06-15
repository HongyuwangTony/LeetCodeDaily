import java.util.HashMap;
import java.util.Map;

/**
 * Q138: Copy List with Random Pointer
 */
public class Q138_CopyListWithRandomPointer {

    // Definition for a Node.
    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    static class Solution {
        public static int id = 1;
        public static Map<Node, Node> transition_map = new HashMap<>(); // old -> new

        public Node copyRandomList(Node head) {
            if (head == null) return null;

            Node head_new = null, prev = null;

            // Traverse through the list with copied old random pointer
            for (Node curr_orig = head; curr_orig != null; curr_orig = curr_orig.next) {
                Node curr = new Node(curr_orig.val, null, curr_orig.random);
                transition_map.put(curr_orig, curr);

                if (head_new == null) head_new = curr;
                else prev.next = curr;
                prev = curr;
            }

            for (Node curr = head_new; curr != null; curr = curr.next) {
                if (curr.random == null) continue;
                curr.random = transition_map.get(curr.random);
            }
            return head_new;
        }
    }

    public static int testNum = 1;

    public static void main(String[] args) {
        // TODO: add tests for this
    }
}
