class TrieNode{
    TrieNode[] children;
    boolean endOfWord;

    public TrieNode(){
        children = new TrieNode[26];
        endOfWord = false;
    }
}

class WordDictionary {
private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            int idx = ch - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.endOfWord  = true;
    }
    public boolean search(String word){
        TrieNode node = root;
        return searchHelper(word, node);
    }

    public boolean searchHelper(String word, TrieNode node) {
        for( int i = 0; i <word.length(); i++){
            char ch = word.charAt(i);
            if(ch == '.'){
                for( TrieNode child : node.children){
                    if(child != null && searchHelper(word.substring(i+1), child)){
                        return true;
                    }
                }
                return false;
                }else{
                    int idx = ch - 'a';
                    if(node.children[idx] == null) return false;
                    node = node.children[idx];
                }
            }
        return node.endOfWord;
    }
}
