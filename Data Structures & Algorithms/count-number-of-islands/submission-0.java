class Solution {

    public void dfs(char[][] grid, int row, int col, boolean isVisited[][]){
        if(row < 0 || col < 0 || row == grid.length || col == grid[0].length || grid[row][col] == '0' || isVisited[row][col]){
            return;
        }

        isVisited[row][col] = true;
        dfs(grid, row + 1, col ,isVisited);
        dfs(grid, row - 1, col ,isVisited);
        dfs(grid, row, col + 1 ,isVisited);
        dfs(grid, row, col - 1 ,isVisited);

        grid[row][col] = '0';
        isVisited[row][col] = false;
    }
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                if(grid[i][j] == '0') continue;
                dfs(grid, i, j, new boolean[grid.length][grid[0].length]);
                cnt++;
            }
        }

        return cnt;
    }
}
