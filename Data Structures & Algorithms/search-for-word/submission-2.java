class Solution {
    public boolean dfs(char[][] board, String word, int i, int j, int idx, boolean[][] isIncluded){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || isIncluded[i][j]){
            return false;
        }

        if(board[i][j] != word.charAt(idx)) return false;

        if(idx == word.length()-1) return true;
        

        isIncluded[i][j] = true;
        idx++;
        boolean what = dfs(board, word, i + 1, j, idx, isIncluded) || dfs(board, word, i-1, j, idx, isIncluded) || dfs(board, word, i, j+1, idx, isIncluded) || dfs(board, word,i, j-1, idx, isIncluded);
        isIncluded[i][j] = false;
        idx--;
        return what;

    }
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        // nested loop for all character
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(board, word, i, j, 0, new boolean[m][n])) return true;
            }
        }

        return false;
    }
}
