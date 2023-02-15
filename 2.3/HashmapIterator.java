package uk.ac.ncl.teach.ex.coll;

import java.util.*;

public class HashMapIterator {
    
  public static void main(String[] args) {
    // create and populate map
    Map<String, String> foo = new HashMap<>();
    foo.put("s1", "James");
    foo.put("s2", "Jane");
    foo.put("s3", "Rich");
    foo.put("s4", "Becky");
    // using for loop and keySet
    for (String id : foo.keySet()) {
      System.out.println("Key: " + id);
    }
    // using for loop and values
    // CAUTION, order is not guaranteed to match KeySet
    for (String name : foo.values()) {
      System.out.println("Value: " + name);
    }
    // using for loop and entrySet
    for (Map.Entry<String, String> entry : foo.entrySet()) {
      System.out.println(
        "Key: " + entry.getKey() + " Value: " + entry.getValue()
      );
    }
  }
}
