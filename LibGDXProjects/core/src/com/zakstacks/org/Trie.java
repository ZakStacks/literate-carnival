package com.zakstacks.org;

/**
 * Created by Zakariyah Toyer on 2017-01-11.
 */

public class Trie {
    private TrieNode root;

    //initialize
    public Trie(){
        root = new TrieNode();
    }

    //insert into the trie
    public void insert(String word){
        TrieNode parent = root;
        for(int i=0; i<word.length(); i++){
            //find the value of the current letter so it can be added to a child node (if not present)
            int letterVal = word.charAt(i)-'a';
            if(parent.arr[letterVal] == null){
                //if there is no child node in that slot, then move down a level
                TrieNode temp = new TrieNode();
                parent.arr[letterVal] = temp;
                parent = temp;
            }
            else{
                //move down a level
                parent = parent.arr[letterVal];
            }
        }
        //word has ended

        parent.last = true;
    }

    //search for a specific node
    public TrieNode searchNode(String word){
        TrieNode parent = root;
        for(int i=0; i<word.length(); i++){
            int letterVal = word.charAt(i)-'a';
            //if there is a child node at the next letter's index, move down
            if(parent.arr[letterVal] == null){
                return null;
            }
            //else its not in the trie
            else{
                parent = parent.arr[letterVal];
            }
            //words are at least 2 letters long
        }
        if(parent == root){
            return null;
        }
        return parent;
    }

    //check if this prefix exists in the wordlist
    public boolean validPrefix(String word){
        TrieNode parent = searchNode(word);
        //if its found, parent wont have a null value
        if(parent != null){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean findWord(String word){
        TrieNode parent = searchNode(word);
        //if its found, parent wont have a null value
        if(parent != null){
            if(parent.last == true) {
                return true;
            }
            return false;
        }
        return false;
    }

}

