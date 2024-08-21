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
    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        rightView(root, 0);
        return result;
    }

    public void rightView(TreeNode node, int depth) {
        if (node == null) return;

        if (result.size() <= depth) result.add(node.val);

        rightView(node.right, depth+1);
        rightView(node.left, depth+1);
    }
}