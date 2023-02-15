package uk.ac.ncl.teach.ex.coll;

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        final String[] colours = { "red", "blue", "orange", "pink", "purple", "red", "green", "blue", "red" };
        final List<String> colourList = Arrays.asList(colours);
        System.out.println("Colours: " + colourList);
        System.out.println("Colours without duplicates: " +
                removeDuplicates(colourList));
        System.out.println("Sorted colours without duplicates: " + sortAndremoveDuplicates(colourList));
    }

    public static Collection<String> removeDuplicates(Collection<String> c) {
        return new HashSet<String>(c);
    }

    public static Collection<String> sortAndremoveDuplicates(Collection<String> c) {
        return new TreeSet<String>(c);
    }
}