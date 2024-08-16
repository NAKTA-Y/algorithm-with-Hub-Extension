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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> bfs = new LinkedList<>();
        List<Integer> vals = new ArrayList<>();

        if (root == null) return result;

        bfs.add(root);

        while (!bfs.isEmpty()) {
            int count = bfs.size();
            vals = new ArrayList<>();

            for (int i = 0; i < count; i++) {
                TreeNode node = bfs.poll();
                vals.add(node.val);

                if (node.left != null) bfs.add(node.left);
                if (node.right != null) bfs.add(node.right);
            }

            result.add(vals);
        }

        return result;
    }
}