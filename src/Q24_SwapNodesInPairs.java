import java.util.LinkedList;
import java.util.List;

public class Q24_SwapNodesInPairs {
    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null) return null;
            if (head.next == null) return head;
            ListNode newHead = null, prev = null;
            boolean toStore = false;
            int first = -1;
            while (head != null) {
                if (toStore) {
                    if (newHead == null) {
                        newHead = new ListNode(head.val);
                        newHead.next = new ListNode(first);
                        prev = newHead.next;
                    } else {
                        prev.next = new ListNode(head.val);
                        prev.next.next = new ListNode(first);
                        prev = prev.next.next;
                    }
                } else {
                    first = head.val;
                }
                toStore = !toStore;
                head = head.next;
            }
            if (toStore) prev.next = new ListNode(first);
            return newHead;
        }
    }

    public static List<Integer> toList(ListNode head) {
        List<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }

    public static ListNode generateLinkedList(List<Integer> list) {
        ListNode head = null, prev = null;
        for (int i : list) {
            if (head == null) {
                head = new ListNode(i);
                prev = head;
            } else {
                prev.next = new ListNode(i);
                prev = prev.next;
            }
        }
        return head;
    }

    public static void test(List<Integer> input, List<Integer> expectedOutput) {
        System.out.println("Test Case " + testNum++ + ":");
        System.out.println("Input: " + input);
        System.out.println("Expected Output: " + expectedOutput);
        ListNode result = new Solution().swapPairs(generateLinkedList(input));
        System.out.println("Actual Output: " + toList(result));
        assert input.toString().equals(toList(result).toString());
        System.out.println();
    }

    public static int testNum = 1;

    public static void main(String[] args) {
        test(List.of(1,2,3,4), List.of(2,1,4,3));
        test(List.of(1), List.of(1));
        test(List.of(1,2,3), List.of(2,1,3));
    }
}
