public class Q2_AddTwoNumbers {
    /**
     *  Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            return addDigits(l1, l2, false);
        }

        public ListNode addOneDigit(ListNode l, boolean carry) {
            if (l == null) {
                if (carry) return new ListNode(1);
                return null;
            }
            int val = l.val + (carry ? 1 : 0);
            if (val == 10) {
                val = 0;
                carry = true;
            } else carry = false;
            ListNode next = addOneDigit(l.next, carry);
            ListNode ret = new ListNode(val);
            ret.next = next;
            return ret;
        }

        public ListNode addDigits(ListNode l1, ListNode l2, boolean carry) {
            if (l1 == null && l2 == null) return addOneDigit(null, carry);
            else if (l2 == null) return addOneDigit(l1, carry);
            else if (l1 == null) return addOneDigit(l2, carry);
            int val = l1.val + l2.val + (carry ? 1 : 0);
            if (val >= 10) {
                val -= 10;
                carry = true;
            } else carry = false;
            ListNode next = addDigits(l1.next, l2.next, carry);
            ListNode ret = new ListNode(val);
            ret.next = next;
            return ret;
        }
    }

    /**
     * Test Code
     */
    public static ListNode createNode(int[] vals) {
        assert vals.length > 0;
        ListNode head = null;
        ListNode tail = null;
        for (int val : vals) {
            if (tail == null) {
                assert head == null;
                tail = new ListNode(val);
                head = tail;
            } else {
                tail.next = new ListNode(val);
                tail = tail.next;
            }
        }
        return head;
    }

    public static void printNode(ListNode node) {
        assert node != null;
        System.out.print(node.val);
        node = node.next;
        while (node != null) {
            System.out.print(" -> " + node.val);
            node = node.next;
        }
        System.out.println();
    }

    public static void test(int[] input1, int[] input2, int[] expectedOutput) {
        System.out.println("Test Case " + testNum++ + ":");
        System.out.println("Input:");
        ListNode node1 = createNode(input1);
        printNode(node1);
        ListNode node2 = createNode(input2);
        printNode(node2);
        System.out.println("Expected Output:");
        ListNode expectedResult = createNode(expectedOutput);
        printNode(expectedResult);
        System.out.println("Actual Output:");
        ListNode result = new Solution().addTwoNumbers(node1, node2);
        printNode(result);
        System.out.println();
    }

    public static int testNum = 1;

    public static void main(String[] args) {
        test(new int[]{2, 4, 3}, new int[]{5, 6, 4}, new int[]{7, 0, 8});
        test(new int[]{5}, new int[]{5}, new int[]{0, 1});
        test(new int[]{1}, new int[]{9, 9}, new int[]{0, 0, 1});
        test(new int[]{9, 1, 6}, new int[]{0}, new int[]{9, 1, 6});

    }
}
