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

        int childCount = 1;
        int nextCount = 2;
        int count = 0;
        while (!bfs.isEmpty()) {
            TreeNode node = bfs.poll();
            if (node == null) continue;
            else {
                vals.add(node.val);
                count++;

                if (node.left == null) nextCount--;
                if (node.right == null) nextCount--; 
                bfs.add(node.left);
                bfs.add(node.right);

                if (count == childCount) {
                    result.add(vals);
                    vals = new ArrayList<>();
                    count = 0;
                    childCount = nextCount;
                    nextCount *= 2;
                }
            }
        }

        return result;
    }
}