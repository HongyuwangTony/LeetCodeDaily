import java.util.ArrayList;
import java.util.LinkedList;
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
        public void levelOrder(LinkedList<TreeNode> currLevel, List<List<Integer>> res, boolean toRight) {
            List<Integer> currLevelVal = new ArrayList<>();
            LinkedList<TreeNode> nextLevel = new LinkedList<>();
            for (TreeNode node : currLevel) {
                currLevelVal.add(node.val);
                if (toRight) {
                    if (node.left != null) nextLevel.addFirst(node.left);
                    if (node.right != null) nextLevel.addFirst(node.right);
                } else {
                    if (node.right != null) nextLevel.addFirst(node.right);
                    if (node.left != null) nextLevel.addFirst(node.left);
                }
            }
            res.add(currLevelVal);
            if (!nextLevel.isEmpty()) levelOrder(nextLevel, res, !toRight);
        }

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            LinkedList<TreeNode> currLevel = new LinkedList<>();
            currLevel.add(root);
            levelOrder(currLevel, res, true);
            return res;
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
