class Solution {
    public void buildGraph(int n, int[][] edges, ArrayList<ArrayList<Integer>> graph) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
    }
    public boolean dfs(
        ArrayList<ArrayList<Integer>> graph, int node, boolean[] isVisited, int parent) {
        isVisited[node] = true;
        for (int nbg : graph.get(node)) {
            if (isVisited[nbg] && nbg != parent) {
                return true;
            }

            if (isVisited[node] && nbg == parent)
                continue;

            if (dfs(graph, nbg, isVisited, node)) {
                return true;
            }
        }

        return false;
    }
    // Every tree is graph but every graph is not tree.
    // cases where graph is not tree: cycle in graph, disconnected graph, unique path for any node
    // in the tree but graph won't
    public boolean validTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        buildGraph(n, edges, graph);

        boolean[] isVisited = new boolean[n];

        // this is for cyclic check
        boolean hasCycle = dfs(graph, 0, isVisited, -1);

        if (hasCycle)
            return false;

        // this is for disconnected graph check
        for (boolean bt : isVisited) {
            if (!bt)
                return false;
        }

        return true;
    }
}
