/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (k == 0) return Collections.singletonList(target.val);

        Map<Integer, TreeNode> parent = new HashMap<>();
        Deque<TreeNode> treeQueue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        treeQueue.add(root);
        
        while (!treeQueue.isEmpty()) {
            TreeNode node = treeQueue.poll();

            if (node.left != null) {
                parent.put(node.left.val, node);
                treeQueue.add(node.left);
            }

            if (node.right != null) {
                parent.put(node.right.val, node);
                treeQueue.add(node.right);
            }
        }

        Set<Integer> visited = new HashSet<>();
        treeQueue.add(target);

        while (k > 0 && !treeQueue.isEmpty()) {
            int size = treeQueue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = treeQueue.poll();
                visited.add(node.val);

                if (node.left != null && !visited.contains(node.left.val)) {
                    treeQueue.add(node.left);
                }

                if (node.right != null && !visited.contains(node.right.val)) {
                    treeQueue.add(node.right);
                }

                if (parent.containsKey(node.val) && !visited.contains(parent.get(node.val).val)) {
                    treeQueue.add(parent.get(node.val));
                }

            }

            k--;
        }

        for (TreeNode node : treeQueue) {
            result.add(node.val);
        }

        return result;
    }
}