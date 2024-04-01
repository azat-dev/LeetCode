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

    private final class LeavesIterator {
        private TreeNode root;
        private TreeNode currentLeaf;
        private LinkedList<TreeNode> nextSubtreeStack;

        LeavesIterator(TreeNode root) {
            this.root = root;
            this.currentLeaf = null;
            this.nextSubtreeStack = new LinkedList<>();
        }

        private TreeNode nextLeafFrom(TreeNode root) {

            if (root.left != null) {
                if (root.right != null) {
                    nextSubtreeStack.push(root.right);
                }
                return nextLeafFrom(root.left);
            }

            if (root.right != null) {
                return nextLeafFrom(root.right);
            }

            this.currentLeaf = root;
            return root;
        }

        TreeNode next() {
            
            if (currentLeaf == null) {
                return nextLeafFrom(root);
            }

            if (nextSubtreeStack.isEmpty()) {
                return null;
            }

            final var nextSubtree = nextSubtreeStack.pop();
            if (nextSubtree == null) {
                return null;
            }

            return nextLeafFrom(nextSubtree);
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        final var iterator1 = new LeavesIterator(root1);
        final var iterator2 = new LeavesIterator(root2);

        while (true) {

            final var next1 = iterator1.next();
            final var next2 = iterator2.next();

            if (next1 == null && next2 == null) {
                return true;
            }

            if (next1 == null || next2 == null) {
                return false;
            }

            if (next1.val != next2.val) {
                return false;
            }
        }
    }
}