/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        
        stack<TreeNode*> nodesStack;
        TreeNode* currentNode = root;
        vector<int> result;
        
        while (currentNode != NULL || !nodesStack.empty()) {
            
            if (currentNode == NULL) {
                
                currentNode = nodesStack.top();
                nodesStack.pop();
                
                result.push_back(currentNode->val);
                currentNode = currentNode->right;
                continue;
            }
            
            if (currentNode->left == NULL) {
                result.push_back(currentNode->val);
                currentNode = currentNode->right;
                continue;
            }
            
            // Push all values from left subtree
            nodesStack.push(currentNode);
            currentNode = currentNode->left;
        }
        
        return result;
    }
};