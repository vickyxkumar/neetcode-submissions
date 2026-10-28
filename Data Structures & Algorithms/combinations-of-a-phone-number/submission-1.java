class Solution {
    public void dfs(String digit, List<String> pad, List<String> ans, int idx, StringBuilder str) {
        if (idx == digit.length()) {
            ans.add(str.toString());

            return;
        }

        String padValue = pad.get((digit.charAt(idx) - '0') - 2);
        for (int i = 0; i < padValue.length(); i++) {
            str.append(padValue.charAt(i));
            dfs(digit, pad, ans, idx + 1, str);
            str.deleteCharAt(str.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> pad =
            new ArrayList<>(List.of("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"));
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        dfs(digits, pad, ans, 0, new StringBuilder());
        return ans;
    }
}
