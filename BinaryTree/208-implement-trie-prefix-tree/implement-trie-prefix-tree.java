class Trie {
    Node root;

    public Trie() {
        root = new Node('\0');
    }
    
    public void insert(String word) {
        Node cur = root;
        for(char c : word.toCharArray()){
            if(cur.children[c-'a'] == null){
                cur.children[c-'a'] = new Node(c);
            }
            cur = cur.children[c-'a'];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        Node cur = root;
        for(char x: word.toCharArray()){
            if(cur.children[x-'a'] == null){
                return false;
            }
            cur = cur.children[x-'a'];
        }
        return cur.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Node cur = root;
        for(char x: prefix.toCharArray()){
            if(cur.children[x-'a'] == null){
                return false;
            }
            cur = cur.children[x-'a'];
        }
        return true;
    }
    class Node{
        private char value;
        private boolean isWord;
        private Node[] children;
        public Node(char value){
            this.value = value;
            this.isWord = false;
            this.children = new Node[26];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */