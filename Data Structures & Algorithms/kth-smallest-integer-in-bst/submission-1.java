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

    public void dfs(TreeNode root, int[]ans, int k){
        if(root == null || ans[1] >= k) return;

        dfs(root.left, ans, k);
        if(ans[1] >= k) return;
        ans[1]++;
        if(k == ans[1]){
            ans[0] = root.val;
            return;
        }
        dfs(root.right, ans, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        int ans[] = new int[2];
        dfs(root, ans, k);
        return ans[0];
    }
}
