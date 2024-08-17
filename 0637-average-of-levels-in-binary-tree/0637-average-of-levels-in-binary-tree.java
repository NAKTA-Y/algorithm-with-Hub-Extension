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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Deque<TreeNode> bfs = new ArrayDeque<>();
        int count = 0;
        long sum = 0;
        bfs.add(root);

        while (!bfs.isEmpty()) {
            count = bfs.size();
            sum = 0;

            for (int i = 0; i < count; i++) {
                TreeNode node = bfs.poll();
                sum += node.val;

                if (node.left != null) bfs.add(node.left);
                if (node.right != null) bfs.add(node.right);
            }
            
            result.add((double)sum / count);
        }

        return result;
    }
}