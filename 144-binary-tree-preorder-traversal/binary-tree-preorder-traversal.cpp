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
    vector<int> preorderTraversal(TreeNode* root) {

        vector<int> result;
        std::stack<TreeNode*> nextSubtreeStack;

        TreeNode* currentNode = root;

        while (currentNode != NULL) {

            result.push_back(currentNode->val);

            if (currentNode->left != NULL) {

                if (currentNode->right != NULL) {
                    nextSubtreeStack.push(currentNode->right);
                }

                currentNode = currentNode->left;
                continue;
            }
            
            if (currentNode->right == NULL) {
                if (nextSubtreeStack.empty()) {
                    break;
                }

                currentNode = nextSubtreeStack.top();
                nextSubtreeStack.pop();
                continue;
            }

            currentNode = currentNode->right;
        }

        return result;
    }
};