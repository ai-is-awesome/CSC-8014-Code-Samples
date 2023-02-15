package uk.ac.ncl.teach.ex.coll;

import java.util.*;

public class HashSetDuplicateWordsExample {
    public static void main(String[] args) {
        // array of words
        String[] words = "What, my name is. What, my name is, What, my name is...".split(" ");
        // create sets
        Set<String> uniques = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        // populate sets
        for (String s : words) {
            if (!uniques.add(s)) {
                duplicates.add(s);
            }
        }
        // print sets
        System.out.println("Unique Words: " + uniques);
        System.out.println("Duplicate Words: " + duplicates);
        // remove all words that are found in duplicates
        uniques.removeAll(duplicates);
        // print sets
        System.out.println("Unique Words: " + uniques);
        System.out.println("Duplicate Words: " + duplicates);
    }
}