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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        final var result = new LinkedList<Integer>();
        final var nextSubtreeStack = new LinkedList<TreeNode>();
        var currentNode = root;

        while (currentNode != null) {

            result.add(currentNode.val);

            if (currentNode.left != null) {

                if (currentNode.right != null) {
                    nextSubtreeStack.push(currentNode.right);
                }

                currentNode = currentNode.left;
                continue;
            }

            if (currentNode.right == null) {
                if (nextSubtreeStack.isEmpty()) {
                    break;
                }

                currentNode = nextSubtreeStack.pop();
                continue;
            }

            currentNode = currentNode.right;
        }

        return result;
    }
}