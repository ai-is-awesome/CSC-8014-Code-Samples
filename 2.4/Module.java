// package uk.ac.ncl.teach.ex.coll;

public final class Module implements Comparable<Module> {
    public static final int MIN_MODULE_NUMBER = 1000;
    public static final int PREFIX_LENGTH = 3;
    private final String prefix;
    private final int number;
    private final int semester;

    public Module(String prefix, int number, int semester) {
        if (prefix.length() != PREFIX_LENGTH)
            throw new IllegalArgumentException("prefix: " + prefix);
        if (number < MIN_MODULE_NUMBER)
            throw new IllegalArgumentException("number: " + number);
        if (semester != 1 && semester != 2)
            throw new IllegalArgumentException("semester: " + semester);
        this.prefix = prefix;
        this.number = number;
        this.semester = semester;
    }

    public String getPrefix() {
        return prefix;
    }

    public int getNumber() {
        return number;
    }

    public int getSemester() {
        return semester;
    }

public int compareTo(Module module) {
final int pCmp = prefix.compareTo(module.prefix);//call compareTo in 
// string class
if (pCmp != 0)
return pCmp;
return number != module.number
? number - module.number
: semester - module.semester; 
}

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Module))
            return false;
        final Module module = (Module) obj;
        // NB this is not consistent with compareTo
        return prefix.equals(module.prefix) && number == module.number;
        // This is consistent with compareTo
        // return prefix.equals(module.prefix) && number == module.number &&
        // semester == module.semester ;
    }

    @Override
    public int hashCode() {
        int hc = 17;
        hc = 37 * hc + prefix.hashCode();
        hc = 37 * hc + number;
        return hc;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder(prefix);
        sb.append(number).append("-").append(semester);
        return sb.toString();
    }
}