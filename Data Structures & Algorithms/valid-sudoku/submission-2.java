class Solution {
    public boolean isPossible(char[][] board, int row, int col, char target) {
        for (int i = 0; i < 9; i++) {
            // check in row
            if (i != row && target == board[i][col]) {
                return false;
            }

            // check in col
            if (i != col && target == board[row][i]) {
                return false;
            }

            // check in 3 x 3 board
            int r = (row / 3) * 3 + i / 3;
            int c = 3 * (col / 3) + i % 3;
            if (r != row && c != col && target == board[r][c]) {
                return false;
            }
        }

        return true;
    }

    public boolean fill(char[][] board, int row, int col) {
        // if i reach to last row and last col then I found the solution

        if (board[row][col] == '.') {
            for (char ch = '1'; ch <= '9'; ch++) {
                if (isPossible(board, row, col, ch)) {
                    board[row][col] = ch;
                }
            }
        }

        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        // return fill(board);

        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                if(board[row][col] == '.') continue;
                if(!isPossible(board, row, col, board[row][col])){
                    return false;
                }
            }
        }

        return true;
    }
}
