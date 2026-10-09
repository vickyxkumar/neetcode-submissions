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

class Solution {// simplest way is add in the list and traverse it and find whether it is increasing or not

    public void addInList(TreeNode root, List<Integer> lst){
        if(root == null) return;

        addInList(root.left, lst);
        lst.add(root.val);
        addInList(root.right, lst);
        
    }
    public boolean isValidBST(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        addInList(root, lst);
        System.out.println(lst.toString());
        int i = 0;
        for(int j = 1; j < lst.size(); j++){
            if(lst.get(i) >= lst.get(j)){
                return false;
            }
            i = j;
        }

        return true; 
    }
}
