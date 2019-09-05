import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q449_SerializeAndDeserializeBST {
    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static class Codec {

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

        private TreeNode deserialize(Queue<Integer> q, int lower, int higher) {
            if (q.isEmpty()) return null;
            int head = q.peek();
            if (head < lower || head > higher) return null;
            TreeNode root = new TreeNode(q.poll());
            root.left = deserialize(q, lower, head);
            root.right = deserialize(q, head, higher);
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
            return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.deserialize(codec.serialize(root));

    public static void main(String[] args) {
        Codec codec = new Codec();
        System.out.println(codec.serialize(codec.deserialize("2,1,3,")));
        System.out.println(codec.serialize(codec.deserialize("9,3,1,7,5,6,12,19,")));
    }
}
