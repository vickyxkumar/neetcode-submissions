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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> lst = new ArrayList<>();
            while(size != 0){
                size--;
                TreeNode node = queue.poll();
                if(node == null) {
                    continue;
                }
                lst.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                
            }

            ans.add(lst);
        }

        return ans;
    }
}
