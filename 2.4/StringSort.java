package uk.ac.ncl.teach.ex.coll;

import java.util.*;

public class StringSort implements Comparator<String> {
    public int compare(String s1, String s2) {
        return s1.toLowerCase().compareTo(s2.toLowerCase());
    }

    public static void main(String args[]) {
        String[] arr = { "one", "two", "three", "four", "Five", "one", "Ten" };
        List<String> list = Arrays.asList(arr);
        Collections.sort(list); // default String sort
        System.out.println(list);
        // case independent String sort
        Collections.sort(list, new StringSort());
        System.out.println(list);
        // String length sort
        Collections.sort(list, new AnotherStringSort());
        System.out.println(list);
    }
}