package com.zakstacks.org;

/**
 * Created by Zakariyah Toyer on 2017-01-11.
 */

public class TrieNode {
    TrieNode[] arr;
    boolean last;

    public TrieNode(){
        //26 letters of the alphabet
        this.arr= new TrieNode[26];
    }
}
