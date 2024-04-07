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
        return minDepth(root, 0);
    }

    private int minDepth(TreeNode root, int count) {
        if (root == null) {
            return count;
        }

        if (root.left == null && root.right == null) {
            return count + 1;
        }

        return Math.min(
            root.left == null ? Integer.MAX_VALUE : minDepth(root.left, count + 1),
            root.right == null ? Integer.MAX_VALUE : minDepth(root.right, count + 1)
        );
    }
}