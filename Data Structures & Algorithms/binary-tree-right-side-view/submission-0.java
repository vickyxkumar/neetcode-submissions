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
    // its always be the last index val for any node in the bfs
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            int rightVal = 0;
            while(size > 0){
                TreeNode node = queue.poll();
                rightVal = node.val;
                if(node.left != null) queue.add(node.left);

                if(node.right != null) queue.add(node.right);
                size--;
            }

            ans.add(rightVal);
        }

        return ans;
    }
}
