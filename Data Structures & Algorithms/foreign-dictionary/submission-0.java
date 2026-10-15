class Solution {
    //
    public boolean buildGraph(HashMap<Character, Set<Character>> graph, String[] words) {
        int j = 1;
        while (j < words.length) {
            String a = words[j - 1], b = words[j];
            int m = 0, n = 0;
            while (m < a.length() && n < b.length()) {
                char ch1 = a.charAt(m), ch2 = b.charAt(n);
                if (ch1 != ch2) {
                    Set<Character> set = graph.get(ch1);
                    set.add(ch2);
                    graph.put(ch1, set);

                    break;
                }

                m++;
                n++;
            }

            if (n == b.length() && m < a.length())
                return false;

            j++;
        }

        return true;
    }

    public String foreignDictionary(String[] words) {
        // build the graph just think that each alphabet represent a number : a - 0, b - 1. You can
        // build using HashMap

        HashMap<Character, Set<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> inDegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegree.putIfAbsent(c, 0);
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        boolean canBuild = buildGraph(graph, words);
        if (!canBuild)
            return "";

        // I have to travese the the graph and take the topolgical sort.

        for (Map.Entry<Character, Set<Character>> entry : graph.entrySet()) {
            for (char ch : entry.getValue()) {
                inDegree.put(ch, inDegree.getOrDefault(ch, 0) + 1);
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0)
                queue.offer(c);
        }

        StringBuilder ans = new StringBuilder("");
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            ans.append(ch);
            for (char nbg : graph.getOrDefault(ch, Collections.emptySet())) {
                inDegree.put(nbg, inDegree.get(nbg) - 1);
                if (inDegree.get(nbg) == 0) {
                    queue.offer(nbg);
                }
            }
        }

        return inDegree.size() != ans.length() ? "" : ans.toString();

        // Two condition where string can't be build
        // 1. if you can't build the graph -- done
        // 2. if there is cycle in the graph
    }
}
