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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return dfs(preorder, 0, n - 1, 0, n - 1, map);
    }

    public TreeNode dfs(int[] preorder, int inorderStart, int inorderEnd, int preorderStart,
        int preorderEnd, HashMap<Integer, Integer> map) {
        if (preorderStart > preorderEnd || inorderStart > preorderEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preorderStart]);

        int rootIndexInInorder = map.get(preorder[preorderStart]);
        int leftIndexInInorder = rootIndexInInorder - inorderStart;

        root.left = dfs(preorder, inorderStart, rootIndexInInorder - 1, preorderStart + 1,
            preorderStart + leftIndexInInorder, map);
        root.right = dfs(preorder, rootIndexInInorder + 1, inorderEnd,
            preorderStart + leftIndexInInorder + 1, preorderEnd, map);

        return root;
    }
}
