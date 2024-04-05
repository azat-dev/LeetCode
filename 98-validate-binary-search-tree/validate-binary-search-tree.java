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

    private boolean isValidBST(
        TreeNode root,
        Integer leftBoundary,
        Integer rightBoundary
    ) {
        if (root == null) {
            return true;
        }

        if (
            leftBoundary != null && root.val <= leftBoundary ||
            rightBoundary != null && root.val >= rightBoundary
        ) {
            return false;
        }

        return isValidBST(root.left, leftBoundary, root.val) && 
            isValidBST(root.right, root.val, rightBoundary); 
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root.left, null, root.val) &&
            isValidBST(root.right, root.val, null);
    }
}