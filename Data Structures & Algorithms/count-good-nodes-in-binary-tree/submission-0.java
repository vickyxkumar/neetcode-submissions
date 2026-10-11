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
    public int dfs(TreeNode root, int tillMax){
        if(root == null) return 0;

        
        int fromLeft = dfs(root.left, Math.max(tillMax, root.val));
        int fromRight = dfs(root.right, Math.max(tillMax, root.val));

        int cnt = root.val >= tillMax ? 1 : 0;

        return fromLeft + fromRight + cnt;
    }
    public int goodNodes(TreeNode root) {
        return dfs(root, -200);   
    }
}
