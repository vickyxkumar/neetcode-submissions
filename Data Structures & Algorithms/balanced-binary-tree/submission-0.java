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

    public int dfs(TreeNode root, boolean[] ans){
        if(root == null){
            return 0;
        }

        int fromLeft = dfs(root.left, ans);
        int fromRight = dfs(root.right, ans);

        if(Math.abs(fromLeft-fromRight) > 1){
            ans[0] = false; 
        }

        return Math.max(fromLeft, fromRight) + 1;

    }

    public boolean isBalanced(TreeNode root) {
        boolean [] ans = {true};

        dfs(root, ans);

        return ans[0];   
    }
}
