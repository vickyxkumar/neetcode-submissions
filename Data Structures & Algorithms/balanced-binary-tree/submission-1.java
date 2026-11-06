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

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int fromLeft = dfs(root.left);
        if(fromLeft == -1) return -1;
        int fromRight = dfs(root.right);
        if(fromRight == -1) return -1;

        if(Math.abs(fromLeft-fromRight) > 1){
            return -1; 
        }

        return Math.max(fromLeft, fromRight) + 1;

    }

    public boolean isBalanced(TreeNode root) {
        boolean [] ans = {true};

        return dfs(root) != -1;

    }
}
