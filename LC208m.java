import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LC208m {
    public static void main(String[] args) throws IOException {
        Trie t = new Trie();

        t.insert("apple");
        System.out.println(t.search("apple"));
    }
}

class Trie {
    Trie[] branches;
    boolean end;
    public Trie() {
        this.branches = new Trie[26];
        this.end = false;
    }
    
    public void insert(String word) {
        Trie cur = this;
        for(int i = 0;i < word.length();i++){
            char c = word.charAt(i);
            if(cur.branches[c - 'a'] == null){
                cur.branches[c - 'a'] = new Trie();
            }
            cur = cur.branches[c - 'a'];
        }
        cur.end = true;
    }
    
    public boolean search(String word) {
        Trie cur = this;
        for(int i = 0;i < word.length();i++){
            char c = word.charAt(i);
            if(cur.branches[c - 'a'] == null){
                return false;
            }
            cur = cur.branches[c - 'a'];
        }
        return cur.end;
        
    }
    
    public boolean startsWith(String prefix) {
        Trie cur = this;
        for(int i = 0;i < prefix.length();i++){
            char c = prefix.charAt(i);
            if(cur.branches[c - 'a'] == null){
                return false;
            }
            cur = cur.branches[c - 'a'];
        }
        return true;
    }
}
