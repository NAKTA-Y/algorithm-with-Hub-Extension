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
    public int minDepth(TreeNode root) {
        Deque<TreeNode> bfs = new ArrayDeque<>();
        int traverse = 1;
        int size = 0;

        if (root == null) return 0;

        bfs.add(root);
        while (!bfs.isEmpty()) {
            size = bfs.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = bfs.poll();

                if (node.left == null && node.right == null) 
                    return traverse;

                if (node.left != null) bfs.add(node.left);
                if (node.right != null) bfs.add(node.right);
            }
            traverse++;
        }

        return traverse;
    }
}