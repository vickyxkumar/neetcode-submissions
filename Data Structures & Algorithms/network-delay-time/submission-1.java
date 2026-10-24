class Solution {
    class Path {
        int src;
        int dest;
        int cost;

        Path(int src, int dest, int cost) {
            this.src = src;
            this.dest = dest;                      
            this.cost = cost;
        }
    }
    public void buildGraph(List<List<Path>> graph, int[][] times, int n) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            Path path = new Path(times[i][0] - 1, times[i][1] - 1, times[i][2]);
            graph.get(times[i][0] - 1).add(path);
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Path>> graph = new ArrayList<>();

        buildGraph(graph, times, n);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        int[] signalCost = new int[n];
        Arrays.fill(signalCost, Integer.MAX_VALUE);
        signalCost[k-1] = 0;

        pq.add(new int[]{k-1, 0});
        boolean [] visited = new boolean[n];

        while (!pq.isEmpty()) {
            int size = pq.size();

            while (size > 0) {
                int[] node = pq.poll();
                visited[node[0]] = true;
                for (Path nbg : graph.get(node[0])) {
                    if (!visited[nbg.dest] && signalCost[nbg.dest] > signalCost[node[0]] + nbg.cost) {
                        signalCost[nbg.dest] = signalCost[node[0]] + nbg.cost;
                        pq.add(new int[]{nbg.dest, signalCost[nbg.dest]});
                    }
                }
                size--;
            }
        }

        int ans = -1;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, signalCost[i]);
        }

        System.out.println(Arrays.toString(signalCost));

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
