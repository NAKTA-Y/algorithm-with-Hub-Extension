public class Solution {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calcMaxDiameter(root);
        return max;
    }

    public int calcMaxDiameter(TreeNode root) {
        if (root == null) return 0;

        int left = calcMaxDiameter(root.left);
        int right = calcMaxDiameter(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }
}