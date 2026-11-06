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

    public int dfs(TreeNode root, int[] maxDia){
        if(root == null){
            return 0;
        }

        int fromLeft = dfs(root.left, maxDia);
        int fromRight = dfs(root.right, maxDia);

        maxDia[0] = Math.max(fromLeft+fromRight+1, maxDia[0]);

        return Math.max(fromLeft, fromRight) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int ans[] = new int[1];
        dfs(root, ans);
        return ans[0]-1;
    }
}
