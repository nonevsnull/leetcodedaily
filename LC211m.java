import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/*
 * Trie模版题
 * 变形的地方是要支持wildcard，"."
 * 
*/
public class LC211m {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String s = br.readLine();

    }
}

class WordDictionary {
    Node root;
    public WordDictionary() {
        this.root = new Node();
    }
    
    public void addWord(String word) {
        root.add(word);
    }
    
    public boolean search(String word) {
        return root.search(word);
    }
}

class Node {
    Node[] branches;
    boolean end;
    Node(){
        this.branches = new Node[26];
    }
    void add(String s){
        Node cur = this;
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(cur.branches[c - 'a'] == null){
                cur.branches[c - 'a'] = new Node();
            }
            cur = cur.branches[c - 'a'];
        }
        cur.end = true;
    }
    boolean search(String s){
        if(s.isEmpty()){
            return end;
        }
        char c = s.charAt(0);
        String str = s.substring(1, s.length());
        if(c == '.'){
            boolean found = false;
            for(int i = 0;i < 26;i++){
                if(branches[i] != null && branches[i].search(str)){
                    found = true;
                    break;
                }
            }
            return found;
        } else if(branches[c - 'a'] == null) {
            return false;
        } else {
            return branches[c - 'a'].search(str);
        }
    }
    // boolean search(String s){
    //     Node cur = this;
    //     for(int i = 0;i < s.length();i++){
    //         char c = s.charAt(i);
    //         if(c == '.'){
    //             boolean found = false;
    //             for(int j = 0;j < 26;j++){
    //                 if(cur.branches[j] != null){
    //                     // System.out.println(c + " " + j + " " + s.substring(i + 1, s.length()));
    //                     if(cur.branches[j].search(s.substring(i + 1, s.length()))){
    //                         // System.out.println(c + " " + j);
    //                         found = true;
    //                         break;
    //                     }
                        
    //                 }
    //             }
    //             return found;
    //         } else if(cur.branches[c - 'a'] == null) {
    //             return false;
    //         } else {
    //             cur = cur.branches[c - 'a'];
    //         }
            
    //     }
    //     return cur.end;
    // }
}