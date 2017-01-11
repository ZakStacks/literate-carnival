package com.zakstacks.org;
import java.io.*;
import java.util.*;

/**
 * Created by Zakariyah Toyer on 2017-01-11.
 */

public class Words {
    static Trie wordList;
    static ArrayList<String> words;
    public Words(){

    }

    public static void add(String filename) throws IOException{
        wordList = new Trie();
        Scanner scanner = new Scanner(new File(filename));
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            wordList.insert(line.toLowerCase());
        }
        scanner.close();
    }

    public static void generateWords(String letters, String word, char currentLetter, int count) {
        int i = 0;
        if (letters.length() == count) {
            for (int j = 0; j < letters.length(); j++) {
                String temp = "" + letters.charAt(j);
                String split = letters.replace(temp, "");
                generateWords(split, temp, letters.charAt(j), count);
            }
            return;
        } else if (wordList.validPrefix(word) || word.length() == 0) {
            if (wordList.findWord(word) && word.length() != 0) {
                if (!words.contains(word)) {
                    words.add(word);
                }
            }
            String split = letters.replace(""+currentLetter, "");
            for (int j = 0; j < split.length(); j++) {
                String temp = word + split.charAt(j);
                generateWords(split, temp, split.charAt(j), count);
            }
        }
    }


    public static void main(String args[]) throws IOException{
        words = new ArrayList<String>();
        //Words With Friends uses the ENABLE dictionary
        add("core/assets/wwf.txt");
        System.out.println(wordList.validPrefix("bla"));
        System.out.println("Enter your letters:");
        Scanner scanner = new Scanner(System.in);
        String letters = scanner.nextLine();
        if(letters.contains("?")){
            letters = letters.replace("?","");
            System.out.println("Possible moves without blank:");
            generateWords(letters,""+letters.charAt(0),' ', letters.length());
            Collections.sort(words, new LengthFirstSort());
            for(int i = 0; i<words.size(); i++){
                System.out.println(words.get(i));
            }

            words.clear();

            for(int i=0; i<26; i++){
                words.clear();
                char blank = (char)('a'+i);
                String temp = letters+blank;
                generateWords(temp,""+temp.charAt(0),' ', temp.length());

                if (words.size()!=0){
                    System.out.println("BLANK: "+blank);
                    for (int j = 0; j < words.size(); j++) {
                        System.out.println(words.get(j));
                    }
                }

            }
        }
        System.out.println("Possible moves:");
        generateWords(letters,""+letters.charAt(0),' ', letters.length());
        Collections.sort(words, new LengthFirstSort());
        for(int i = 0; i<words.size(); i++){
            System.out.println(words.get(i));
        }
        System.out.println(words.size());

    }
}
