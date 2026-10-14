class Solution {

    public void dfs(int [][] heights, int row, int col, int[][] record, boolean[][] isVisited, int child, boolean isAtlantic, List<List<Integer>> ans){
        // first check point is can I go pacfic
        if(row  < 0 || col < 0 || row >= heights.length || col >= heights[0].length || isVisited[row][col]){
            return;
        }

        if(heights[row][col] < child){
            return;
        }

        isVisited[row][col] = true;

        dfs(heights, row+1, col, record, isVisited, heights[row][col], isAtlantic, ans);
        dfs(heights, row-1, col, record, isVisited, heights[row][col], isAtlantic, ans);
        dfs(heights, row, col+1, record, isVisited, heights[row][col], isAtlantic, ans);
        dfs(heights, row, col-1, record, isVisited, heights[row][col], isAtlantic, ans);

        if(isAtlantic){
            if(record[row][col] == 1){
                List<Integer> lst = new ArrayList<>();
                lst.add(row);
                lst.add(col);
                ans.add(new ArrayList<>(lst));
            }
        }else{
            record[row][col] = 1;
        }

    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // otimization is that check only from border and reverse the condition

                List<List<Integer>> ans = new ArrayList<>();

        int n = heights.length, m = heights[0].length;
        boolean isVisited[][] = new boolean[n][m];

        // lets check for pacific first
        int record[][] = new  int[n][m];

        for(int i = 0; i< m ;i++){
            dfs(heights, 0, i, record, isVisited, -1, false, ans);
        }

        for(int i = 0; i< n; i++){
            dfs(heights, i, 0, record, isVisited, -1, false, ans);
        }

        isVisited = new boolean[n][m];
        int record1[][] = new int[n][m];
 
        // this is for atlantic
        for(int i = 0; i< m ;i++){
            dfs(heights, n-1, i, record, isVisited, -1, true, ans);
        }

        for(int i = 0; i< n ;i++){
            dfs(heights, i, m-1, record, isVisited, -1, true, ans);
        }



        // for(int i = 0; i< n; i++){
        //     for(int j = 0; j < m; j++){
        //         if(record[row][col] >= 2){
        //             List<Integer> lst = new ArrayList<>();
        //             lst.add(i);
        //             lst.add(j);
        //             ans.add(new ArrayList<>(lst));
        //         }
        //     }
        // }

        return ans;
    }
}
