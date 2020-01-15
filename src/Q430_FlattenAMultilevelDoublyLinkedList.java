public class Q430_FlattenAMultilevelDoublyLinkedList {
    // Definition for a Node.
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    class Solution {
        private Node flattenHelper(Node head, Node parent) {
            if (parent != null) {
                parent.next = head;
                parent.child = null;
                head.prev = parent;
            }

            while (head.next != null) {
                if (head.child != null) {
                    Node next = head.next;
                    head = flattenHelper(head.child, head);
                    head.next = next;
                    next.prev = head;
                }
                head = head.next;
            }
            if (head.child != null) head = flattenHelper(head.child, head);
            return head;
        }

        public Node flatten(Node head) {
            if (head == null) return null;
            flattenHelper(head, null);
            return head;
        }
    }
}
