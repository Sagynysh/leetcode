package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    private List<String> list = new ArrayList<>();

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        list.add(word);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        for(String tmp:list){
            if(tmp.equals(word)){
                return true;
            }
        }
        return false;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        for(String tmp:list){
            if(prefix.length()<=tmp.length() && tmp.startsWith(prefix)){
                return true;
            }
        }
        return false;

    }
}
