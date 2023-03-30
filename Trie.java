public class Trie{
    static final int alphaSize = 26;
    class TrieNode{
        TrieNode[] arr = new TrieNode[alphaSize];
        boolean isEnd ;
        int prefix;
        
        TrieNode(){
            this.isEnd = false;
            for(int i = 0 ;i<alphaSize;i++){
                this.arr[i] = null;
            }
            this.prefix = 0;
        }
}
Trie(){
    this.root = new TrieNode();
}
static TrieNode root;
public void insert(String key){
    int ind;
    TrieNode pcrawl = root;
    
    for(int  i = 0;i<key.length();i++){
        ind = key.charAt(i) - 'a';
        if(pcrawl.arr[ind] == null){
        pcrawl.arr[ind] = new TrieNode();
        // pcrawl.prefix++;
    }
        pcrawl = pcrawl.arr[ind];
        pcrawl.prefix++;

    }
    pcrawl.isEnd = true;
}
public boolean search(String key){
    TrieNode pcrawl = root;
    int ind;
    for(int i = 0 ;i<key.length();i++){
        ind = key.charAt(i) - 'a';
        if(pcrawl.arr[ind] == null ) return false;
        else pcrawl = pcrawl.arr[ind];
    }
    return pcrawl.isEnd;
}

public int noOfWords(String key){
    int ind;
    TrieNode pcrawl = root;
    for(int i = 0 ;i<key.length();i++){
        ind = key.charAt(i) - 'a';
        if(pcrawl.arr[ind]  == null) return -1;
        else pcrawl = pcrawl.arr[ind];
    }
    return pcrawl.prefix;
}

public void delete(String key){
    TrieNode pcrawl = root;
    int ind ;
    for(int i = 0 ;i<key.length();i++){
        ind = key.charAt(i) - 'a';
        if(pcrawl.arr[ind] == null) {
            System.out.println(key + "doesn't exist");
            return ;
        }
        else pcrawl = pcrawl.arr[ind];
    }
    pcrawl.isEnd = false;
    return;
}

// private String[] auto(TrieNode root){
//     int ind =0;
//     char ch;
//     System.out.println(root.prefix);
//     String[] arr = new String[root.prefix] ;
//     if(root.isEnd){
//         for(int i = 0;i<alphaSize;i++){
//             if(root.arr!=null) {
//             ch= (char)((int)'a' + i);
//             arr[ind] += ch;
//             return arr;
//             }
//         }
//     }
//     for(int i = 0 ;i<alphaSize;i++){
//         if(root.arr!=null) 
//         {
//             String[] res = auto(root.arr[i]);
//             for(int j = 0;j<res.length;j++){
//                 arr[ind] += res[j];
//                 ind ++;
//             }
//         }
//     }
//     return arr;
    
// }

// public void autoComplete(String key){
//     TrieNode pcrawl  = root;
//     int ind = 0;
//     for(int  i = 0 ;i<key.length();i++){
//         ind = key.charAt(i) - 'a';
//         pcrawl = pcrawl.arr[ind];
//     }
//     String[] res = auto(pcrawl);
//     for(int k = 0 ;k<res.length;k++){
//         System.out.println(res[k]);
//     }
// }



public static void main(String[] args){
    Trie trie = new Trie();
    // trie.insert("karthikeya");
    // trie.insert("karthik");
    // System.out.println("karthik : " +trie.search("karthik"));
    // System.out.println("karthikeya : " +trie.search("karthikeya"));
    // trie.delete("karthik");
    // System.out.println("karthik : " +trie.search("karthik"));
    // System.out.println("karthikeya : " +trie.search("karthikeya"));
    trie.insert("abac");
    trie.insert("abaa");
    trie.insert("abab");
    trie.insert("aabb");
    trie.insert("aabc");

    System.out.println("ab = " + trie.noOfWords("ab"));
    System.out.println("aba = " + trie.noOfWords("aba"));
    System.out.println("abaa = " + trie.noOfWords("abaa"));
    System.out.println("ac = " + trie.noOfWords("ac"));
    System.out.println("aa = " + trie.noOfWords("aa"));

    // System.out.println("\nauto complete :");
    // trie.autoComplete("ab");
    
    }
}