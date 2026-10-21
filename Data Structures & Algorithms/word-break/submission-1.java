class Solution {
    // My intutation is to use the trie ds

    class Node{
        Node[] children;
        boolean eow;

        Node(){
            children =  new Node[26];
            eow = false;
            for(int i = 0; i< 26; i++){
                children[i] =  null;
            }
        }
    }

    class Trie{
        public void insertWord(Node head, String word){
            Node curr = head;
            for(char ch : word.toCharArray()){
                int idx = ch - 'a';
                if(curr.children[idx] == null){
                    curr.children[idx] = new Node();
                }

                curr = curr.children[idx];
            }

            curr.eow = true;
        }
    }

    public boolean dfs(String s, int idx, Node head, boolean dp[]){

        if(idx == s.length()) return true;

        if(head == null) return false;

        if(dp[idx]) return false;

        Node curr = head;

        for(int i = idx; i< s.length(); i++){
            int charVal = s.charAt(i) - 'a';

            if(curr.children[charVal] == null){
                break;
            }

            curr = curr.children[charVal];

            if(curr.eow && dfs(s, i + 1, head, dp)){
                return true;
            }
        }

        dp[idx] = true;

        return false;
    
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        

        Node head = new Node();

        Trie trie = new Trie();
        boolean dp [] = new boolean[s.length()];

        for(String word : wordDict){
            trie.insertWord(head, word);
        }

        return dfs(s, 0, head,dp);

    }
}
