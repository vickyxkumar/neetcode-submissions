class Solution {

    class Node{
        HashMap<Character, Node> children;
        boolean eow;

        Node(){
            children = new HashMap<>();
            eow = false;
        }
    }

    public void dfs(char[][] board, Node root, int row, int col, boolean [][] isVisited, List<String> ans, StringBuilder word){
        if(row < 0 || col < 0 || row == board.length || col == board[0].length || isVisited[row][col] || root == null){
            return;
        }

        char ch = board[row][col];
        if(!root.children.containsKey(ch)){
            return;
        }
        word.append(ch);
        isVisited[row][col] = true;
        Node nextNode = root.children.get(ch);
        if(nextNode.eow){
            ans.add(word.toString());
            nextNode.eow = false; // Prevent duplicate entries
        }

        dfs(board, nextNode, row + 1, col, isVisited, ans, word);
        dfs(board, nextNode, row - 1, col, isVisited, ans, word);
        dfs(board, nextNode, row, col + 1, isVisited, ans, word);
        dfs(board, nextNode, row, col - 1, isVisited, ans, word);

        isVisited[row][col] = false;
        word.deleteCharAt(word.length()-1);
    }
    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();
        for(String str : words){
            Node curr = root;
            for(char ch : str.toCharArray()){
                if(!curr.children.containsKey(ch)){
                    curr.children.put(ch, new Node());
                }
                curr = curr.children.get(ch);
            }
            curr.eow = true;
        }

        List<String> ans = new ArrayList<>();

        int n = board.length, m = board[0].length;
        for(int i = 0; i< n; i++){
            for(int j = 0; j < m; j++){
                dfs(board, root, i, j, new boolean[n][m], ans, new StringBuilder());
            }
        }

        return ans;
    }
}
