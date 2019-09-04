import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q449_SerializeAndDeserializeBST {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            Stack<TreeNode> s = new Stack<>();
            if (root != null) s.push(root);
            while (!s.empty()) {
                root = s.pop();
                sb.append(root.val).append(',');
                if (root.right != null) s.push(root.right);
                if (root.left != null) s.push(root.left);
            }
            return sb.toString();
        }

        private TreeNode deserialize(Queue<Integer> q) {
            if (q.isEmpty()) return null;
            TreeNode root = new TreeNode(Integer.valueOf(q.poll()));
            Queue<Integer> q_left = new LinkedList<>();
            while (!q.isEmpty() && q.peek() < root.val) {
                q_left.offer(q.poll());
            }
            root.left = deserialize(q_left);
            root.right = deserialize(q);
            return root;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.length() == 0) return null;
            String[] vals = data.split(",");
            Queue<Integer> q = new LinkedList<>();
            for (String val : vals) {
                q.offer(Integer.valueOf(val));
            }
            return deserialize(q);
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.deserialize(codec.serialize(root));

    public static void main(String[] args) {

    }
}
