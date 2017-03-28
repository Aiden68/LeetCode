/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int minDeep = 1 << 30;
    void dfs(TreeNode* root, int deep)
    {
        if(root->left == NULL && root->right == NULL)
        {
            if(minDeep > deep)
                minDeep = deep;
            return;
        }
        if(root->left != NULL)
            dfs(root->left, deep + 1);
        if(root -> right != NULL)
            dfs(root->right, deep + 1);
    }
    int minDepth(TreeNode* root) {
        if(root == NULL)
            return 0;
        dfs(root, 1);
        return minDeep;
    }
};