class Solution {
    // when you start dfs in the visited array that's mean a component
    public void buildGraph(ArrayList<ArrayList<Integer>> graph, int[][] edges, int n){
        for(int i = 0; i< n;i++){
            graph.add(new ArrayList<>());
        }

        for(int [] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }

    public void dfs(ArrayList<ArrayList<Integer>> graph, int node, boolean isVisited[]){

        isVisited[node] = true;

        for(int nbg : graph.get(node)){
            if(isVisited[nbg]) continue;

            dfs(graph, nbg, isVisited);
        }
    }

    public int countComponents(int n, int[][] edges) {


        // build the graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        buildGraph(graph, edges, n);

        // take the visited boolean indicating each node
        boolean isVisited[] = new boolean[n];

        // run a for loop for each node and find the number of dfs required. Maintain a count for this which is our ans.
        int cnt = 0;
        for(int i = 0; i< n; i++){
            if(!isVisited[i]){
                cnt++;
                dfs(graph, i, isVisited);
            }
        }

        return cnt;

    }
}
