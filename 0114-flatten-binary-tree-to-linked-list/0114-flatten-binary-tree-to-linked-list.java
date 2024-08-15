/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        savePreOrder(root, stack);

        if (stack.isEmpty() || stack.size() == 1) return;

        TreeNode child = stack.pop();
        while (!stack.isEmpty()) {
            TreeNode parent = stack.pop();
            parent.right = child;
            parent.left = null;
            child = parent;
        }
    }

    public void savePreOrder(TreeNode cursor, Deque<TreeNode> stack) {
        if (cursor == null) return;

        stack.push(cursor);

        savePreOrder(cursor.left, stack);
        savePreOrder(cursor.right, stack);
    }
}