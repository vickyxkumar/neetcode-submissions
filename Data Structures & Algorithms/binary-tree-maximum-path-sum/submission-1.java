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
    public int dfs(TreeNode root, int[] maxSum){
        if(root == null) return -2000;

        int fromLeft = dfs(root.left, maxSum);
        int fromRight = dfs(root.right, maxSum);

        maxSum[0] = Math.max(Math.max(Math.max(Math.max(Math.max(fromLeft, fromRight), Math.max(fromLeft+root.val, fromRight+root.val)), fromLeft+fromRight+root.val), root.val), maxSum[0]);
        return Math.max(Math.max(fromLeft, fromRight)+root.val, root.val);
    }
    public int maxPathSum(TreeNode root) {
        int[] ans = {-2000};
        dfs(root, ans);
        return ans[0];
    }
}
