/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node dfs(Node node, HashMap<Node, Node> map) {
        List<Node> neighbors = node.neighbors;

        if (map.containsKey(node))
            return map.get(node);

        Node clone = new Node(node.val);
        map.put(node, clone);

        for (Node nbg : neighbors) {
            Node find = dfs(nbg, map);
            clone.neighbors.add(find);
        }

        return clone;
    }
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        return dfs(node, new HashMap<>());
    }
}