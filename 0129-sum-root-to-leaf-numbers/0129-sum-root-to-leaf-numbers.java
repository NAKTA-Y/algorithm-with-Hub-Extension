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
    public int sumNumbers(TreeNode root) {
        return dfs(root, new StringBuilder(root.val));
    }

    private int dfs(TreeNode root, StringBuilder num) {
        if (root == null) return 0;

        num.append(root.val);
        if (root.left == null && root.right == null) {
            return Integer.parseInt(num.toString());
        }

        return dfs(root.left, new StringBuilder(num.toString())) + dfs(root.right, new StringBuilder(num.toString()));
    }
}