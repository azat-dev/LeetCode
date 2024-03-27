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

    class NodeSummary {
        int numberOfChildrenLeft;
        int numberOfChildrenRight;
        int sum;

        NodeSummary(int sum, int numberOfChildrenLeft, int numberOfChildrenRight) {
            this.sum = sum;
            this.numberOfChildrenLeft = numberOfChildrenLeft;
            this.numberOfChildrenRight = numberOfChildrenRight;
        }

        String getHash() {
            return "" + sum + numberOfChildrenLeft + numberOfChildrenRight;
        }
    }

    @FunctionalInterface
    interface WalkTreeCallback{
        boolean execute(TreeNode node, NodeSummary nodeInfo);
    }

    private boolean isEqual(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        }

        return isEqual(node1.left, node2.left) && isEqual(node1.right, node2.right);
    }

    private NodeSummary walkTreeFromBottom(TreeNode root, WalkTreeCallback callback) {
        if (root == null) {
            return new NodeSummary(0, 0, 0);
        }

        final var leftHash = walkTreeFromBottom(root.left, callback);
        if (leftHash == null) {
            return null;
        }

        final var rightHash = walkTreeFromBottom(root.right, callback);
        if (rightHash == null) {
            return null;
        }

        final var hash = new NodeSummary(
            root.val + leftHash.sum + rightHash.sum,
            leftHash.numberOfChildrenLeft + leftHash.numberOfChildrenRight + 1,
            rightHash.numberOfChildrenLeft + rightHash.numberOfChildrenRight + 1
        );

        final var stop = callback.execute(
            root,
            hash
        );

        if (stop) {
            return null;
        }

        return hash;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        final var nodesByHash = new HashMap<String, List<TreeNode>>();
        
        walkTreeFromBottom(root, (TreeNode node, NodeSummary nodeInfo) -> {
            
            final var hash = nodeInfo.getHash();
            final var existingGroup = nodesByHash.get(hash);

            if (existingGroup != null) {
                existingGroup.add(node);
                return false;
            }

            final var newGroup = new ArrayList<TreeNode>();
            newGroup.add(node);

            nodesByHash.put(hash, newGroup);
            return false;
        });

        final var duplicates = new HashSet<TreeNode>();

        for (var group : nodesByHash.values()) {

            if (group.size() == 1) {
                continue;
            }

            for (int i = 0; i < group.size(); i++) {
                
                final var node1 = group.get(i);
                var foundDuplicate = false;

                for (int j = i + 1; j < group.size(); j++) {
                    
                    final var node2 = group.get(j);

                    if (isEqual(node1, node2)) {
                        group.set(j, null);
                        foundDuplicate = true;
                    }
                }

                if (!foundDuplicate) {
                    group.set(i, null);
                }
            }

            for (var node : group) {
                if (node == null) {
                    continue;
                }

                duplicates.add(node);
            }
        }

        return new ArrayList<>(duplicates);
    }
}