/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder("");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append("X "); 
                    continue;
                }
                else 
                    sb.append(node.val + " ");

                queue.add(node.left);
                queue.add(node.right);
            }
        }

        System.out.println(sb.toString());

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        Deque<TreeNode> queue = new ArrayDeque<>();
        String[] split = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        queue.add(root);

        for (int i = 1; i < split.length; i++) {
            TreeNode parent = queue.poll();
            if (!split[i].equals("X")) {
                TreeNode left = new TreeNode(Integer.parseInt(split[i]));
                parent.left = left;
                queue.add(left);
            }

            if (!split[++i].equals("X")) {
                TreeNode right = new TreeNode(Integer.parseInt(split[i]));
                parent.right = right;
                queue.add(right);
            }
        }

        return root;
    }
}