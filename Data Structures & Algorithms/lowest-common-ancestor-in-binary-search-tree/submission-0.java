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
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q, TreeNode []ans){
        if(root == null){
            return false;
        }

        boolean left = dfs(root.left, p, q, ans);
        boolean right = dfs(root.right, p, q, ans);

        if((left && right) || (left && (root == p || root == q)) || (right && (root == p || root == q))){
            System.out.println(root.val);
            ans[0] = root;
        }

        return left || right || root == p || root == q;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode [] ans = new TreeNode[1];
        dfs(root, p, q, ans);

        return ans[0];
    }
}
