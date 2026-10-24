class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";
        HashMap<Character, Integer> history = new HashMap<>();
        HashMap<Character, Integer> counter = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            history.put(ch, history.getOrDefault(ch, 0) + 1);
        }

        int i = 0, j = 0, left = -1, right = -1, len = Integer.MAX_VALUE, have = 0,
            must = history.size();

        while (j < s.length()) {
            char ch = s.charAt(j);

            counter.put(ch, counter.getOrDefault(ch, 0) + 1);
            if (history.containsKey(ch) && counter.get(ch).intValue() == history.get(ch).intValue()) {
                have++;
            }

            while (have == must) {
                // calculate the len, left, right and check is that samllest
                if ((j - i + 1) < len) {
                    left = i;
                    right = j;
                    len = j - i + 1;
                }
                char ch2 = s.charAt(i);
                // move the i pointer and if it matches with the key then subtract have only when
                // key in counter less than key in history
                counter.put(ch2, counter.get(ch2) - 1);

                if (history.containsKey(ch2) && counter.get(ch2) < history.get(ch2)) {
                    have--;
                }

                i++;
            }

            j++;
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(left, right + 1);
    }
}
