public class Q98_ValidateBinarySearchTree {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    class Solution {
        public boolean isValidBST(TreeNode root, long lower, long upper) {
            if (root == null) return true;
            if ((long)root.val <= lower || (long)root.val >= upper) return false;
            return isValidBST(root.left, lower, Math.min(upper, root.val)) &&
                    isValidBST(root.right, Math.max(lower, root.val), upper);
        }

        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }
    }
}
