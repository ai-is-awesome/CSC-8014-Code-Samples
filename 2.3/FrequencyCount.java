package uk.ac.ncl.teach.ex.coll;

import java.util.*;

public class FrequencyCount {
    public static void main(String args[]) {
        // array of Words
        String[] words = "My name is What? My name is Who? My name is ...".split(" ");
        Integer freq;
        Map<String, Integer> wordMap = new HashMap<String, Integer>();
        // Keys:the words
        // Vals:their frequency
        for (String word : words) {
            // get value associated with key
            // if it does not exist, default value = 0
            freq = wordMap.getOrDefault(word, 0);
            freq++;
            wordMap.put(word, freq);
        }
        System.out.print(wordMap.size());
        System.out.println(" distinct words detected");
        System.out.println(wordMap);
        Map<String, Integer> sortedMap = new TreeMap<String, Integer>(wordMap);
        System.out.println("In Sorted Order:");
        System.out.println(sortedMap);
    }
}