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
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q, TreeNode []ans, boolean isPMatched, boolean isQMatched){
        if(root == null){
            return false;
        }

        if(isPMatched && isQMatched) return true;

        isPMatched = root == p ? true : false;
        isQMatched = root == q ? true : false;

        boolean left = dfs(root.left, p, q, ans, isPMatched, isQMatched);
        boolean right = dfs(root.right, p, q, ans, isPMatched, isQMatched);

        if((left && right) || (left && (isPMatched || isQMatched)) || (right && (isPMatched || isQMatched))){
            System.out.println(root.val);
            ans[0] = root;
            return true;
        }

        return left || right || root == p || root == q;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode [] ans = new TreeNode[1];
        dfs(root, p, q, ans, false, false);

        return ans[0];
    }
}
