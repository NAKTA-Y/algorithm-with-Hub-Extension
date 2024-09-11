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
    List<String> paths = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        int sum = 0;
        dfs(root, new StringBuilder(root.val));
        for (String path : paths) sum += Integer.parseInt(path);
        return sum;
    }

    private void dfs(TreeNode root, StringBuilder num) {
        if (root == null) return;

        num.append(root.val);
        if (root.left == null && root.right == null) {
            paths.add(num.toString());
            return;
        }

        dfs(root.left, new StringBuilder(num.toString()));
        dfs(root.right, new StringBuilder(num.toString()));
    }
}