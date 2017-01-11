package com.zakstacks.org;

import java.util.Comparator;

/**
 * Created by Zakariyah Toyer on 2017-01-11.
 */

public class LengthFirstSort implements Comparator<String> {
    @Override
    public int compare(String word1, String word2) {
        if (word1.length()!=word2.length()) {
            return word2.length()-word1.length();
        }
        return word1.compareTo(word2);
    }
}
