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

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        var depth = -1;

        if (root.left != null) {
            depth = minDepth(root.left);
        }

        if (root.right != null) {
            final var rightDepth = minDepth(root.right);

            if (depth == -1 || depth > rightDepth) {
                depth = rightDepth;
            }
        }

        return depth + 1;
    }
}