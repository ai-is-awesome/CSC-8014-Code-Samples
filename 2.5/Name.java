package uk.ac.ncl.teach.ex.factory.name;

import java.util.HashMap;
import java.util.Map;

public final class Name {
    private static final Map<String, Name> NAMES = new HashMap<String, Name>();
    private final String firstName, lastName, strRep;

    private Name(String firstName, String lastName, String strRep) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.strRep = strRep;
    }

    public static Name getInstance(String firstName, String lastName) {
        String strRep = firstName + " " + lastName;
        Name name = NAMES.get(strRep);
        if (name == null) {
            name = new Name(firstName, lastName, strRep);
            NAMES.put(strRep, name);
        }
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getlasstName() {
        return lastName;
    }

    public String toString() {
        return strRep;
    }
}