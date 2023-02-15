import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class UseModule {
    public static void main(String[] args) {
        final Module[] modulesArray = new Module[] {
                new Module("CSC", 8005, 2),
                new Module("CSC", 8002, 2),
                new Module("MAS", 1006, 2),
                new Module("JPN", 1004, 1),
                new Module("CSC", 8005, 1),
                new Module("CSC", 1014, 2),
                new Module("JPN", 1004, 1)
        };
        System.out.println("direct module comparison: "
                + modulesArray[1].compareTo(modulesArray[0]));
        // unordered (HashSet), no duplicates (Set interface uses equals)
        final Set<Module> unsortedModulesSet = new HashSet<Module>();
        // ordered (TreeSet), duplicates (SortedSet interface uses compareTo)
        final SortedSet<Module> sortedModulesSet = new TreeSet<Module>();
        for (final Module m : modulesArray) {
            sortedModulesSet.add(m);
            unsortedModulesSet.add(m);
        }
        System.out.println("array of modules:        "
                + Arrays.toString(modulesArray));
        System.out.println("sorted set of modules:   "
                + sortedModulesSet);
        System.out.println("unsorted set of modules: "
                + unsortedModulesSet);
    }
}
