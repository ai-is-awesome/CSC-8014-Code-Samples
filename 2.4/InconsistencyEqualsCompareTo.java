import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class InconsistencyEqualsCompareTo {
    public static void main(String[] args) {
        Module module1 = new Module("CSC", 8014, 1);
        Module module2 = new Module("CSC", 8014, 2);
        Set<Module> set = new HashSet<Module>();
        set.add(module1);
        set.add(module2);
        System.out.println("HashSet " + set);
        Set<Module> treeSet = new TreeSet<Module>();
        treeSet.add(module1);
        treeSet.add(module2);
        System.out.println("TreeSet " + treeSet);
    }
}

