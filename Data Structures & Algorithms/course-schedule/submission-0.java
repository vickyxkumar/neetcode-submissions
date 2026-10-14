class Solution {
    // dedect a cycle in the directed graph, if there is then can't be finished else can finished
    // detecting a cycle in directed graph can be done via topological sort

    public void buildGraph(
        ArrayList<ArrayList<Integer>> graph, int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        buildGraph(graph, numCourses, prerequisites);

        // apply the toposort and have to detect the cycle
        int inorder[] = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            for(int node : graph.get(i)){
                inorder[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(inorder[i] == 0) queue.add(i);
        }
        

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size != 0){
                int node = queue.poll();
                for(int nbg : graph.get(node)){
                    inorder[nbg]--;
                    if(inorder[nbg] == 0) queue.add(nbg);
                }
                size--;
            }
        }

        for(int val : inorder){
            if(val != 0) return false;
        }

        return true;
    }
}
