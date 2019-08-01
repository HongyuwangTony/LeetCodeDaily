import java.util.List;

public class Q103_BinaryTreeZigzagLevelOrderTraversal {
    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3), node1 = new TreeNode(20);
        root.left = new TreeNode(9);
        root.right = node1;
        node1.left = new TreeNode(15);
        node1.right = new TreeNode(7);
        System.out.println(new Solution().zigzagLevelOrder(root));
    }
}
