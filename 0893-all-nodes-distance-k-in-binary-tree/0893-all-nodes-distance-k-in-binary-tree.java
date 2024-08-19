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

        Map<Integer, Set<Integer>> adj = new HashMap<>();
        Deque<TreeNode> treeQueue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        treeQueue.add(root);
        Set<Integer> rootSet = new HashSet<>();
        adj.put(root.val, rootSet);
        
        while (!treeQueue.isEmpty()) {
            TreeNode node = treeQueue.poll();
            Set<Integer> parentSet = adj.get(node.val);

            if (node.left != null) {
                Set<Integer> leftSet = new HashSet<>();
                TreeNode left = node.left;

                parentSet.add(left.val);
                leftSet.add(node.val);

                adj.put(left.val, leftSet);
                treeQueue.add(left);
            }

            if (node.right != null) {
                Set<Integer> rightSet = new HashSet<>();
                TreeNode right = node.right;

                parentSet.add(right.val);
                rightSet.add(node.val);
                
                adj.put(right.val, rightSet);
                treeQueue.add(right);
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(target.val);
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int val = queue.poll();
                visited.add(val);

                for (int connect : adj.get(val)) {
                    if (visited.contains(connect)) continue;
                    queue.add(connect);
                }
            }

            if (depth++ == k) break;
        }

        return new ArrayList(queue);
    }
}