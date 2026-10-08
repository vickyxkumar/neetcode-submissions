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

public class Codec {

    private void encode(TreeNode root, StringBuilder str){
        if(root == null){
            str.append("@#");
            return;
        }

        str.append(Integer.toString(root.val)).append("#");
        encode(root.left, str);
        encode(root.right, str);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder("");
        encode(root, str);
        System.out.println(str.toString());
        return str.toString();
    }

    private TreeNode decode(Queue<String> nodes){
        if(nodes.isEmpty()) return null;
        String val = nodes.poll();
        if(val.equals("@")) return null;

        TreeNode newNode = new TreeNode(Integer.parseInt(val));

        newNode.left = decode(nodes);
        newNode.right = decode(nodes);

        return newNode;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split("#")));
        return decode(nodes);
    }
}
