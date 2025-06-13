class Solution {
    class TrieNode{
    TrieNode[] children ;
    String word;
    public TrieNode(){
        children = new TrieNode[26];
     }
    }

    public TrieNode buildTrie(String[] words){
    TrieNode root = new TrieNode();
    for( String word : words){
        TrieNode p = root;
        for(char ch : word.toCharArray()){
            int idx = ch - 'a';
            if(p.children[idx] == null){
                p.children[idx] = new TrieNode();
            }
            p = p.children[idx];

        }
        p.word = word;
    }
    return root;
}

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        TrieNode node = buildTrie(words);

        for(int r = 0; r < board.length; r++ ){
            for(int c = 0; c < board[0].length; c++){
                dfs(board, r, c, node, res);
            }
        }
        return new ArrayList(res);
    }

    public void dfs(char[][] board, int r, int c, TrieNode node, Set<String> res){
        if( r < 0 || c < 0 || r >= board.length || c >= board[0].length) return;
        char ch = board[r][c];
        if( ch == '#' || node.children[ch - 'a'] == null ){
            return;
        }
        node  = node.children[board[r][c] - 'a'];
        if( node.word != null){
            res.add(node.word);
        }
        board[r][c] = '#';
        dfs(board, r+1, c, node, res);
        dfs(board, r, c+1, node, res);
        dfs(board, r-1, c, node, res);
        dfs(board, r, c-1, node, res);
        board[r][c] = ch;                        
    }
}