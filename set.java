import java.util.*;

public class SetProblems {

    /* ---------- Find Unique Elements ---------- */
    public static Set<Integer> findUnique(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int x : arr) {
            set.add(x);
        }
        return set;
    }

    /* ---------- Search Element ---------- */
    public static boolean searchElement(Set<Integer> set, int key) {
        return set.contains(key);
    }

    /* ---------- Sorting Elements ---------- */
    public static List<Integer> sortElements(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }

    /* ---------- Remove Duplicates ---------- */
    public static int[] removeDuplicates(int[] arr) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int x : arr) {
            set.add(x);
        }
        int[] res = new int[set.size()];
        int i = 0;
        for (int x : set) {
            res[i++] = x;
        }
        return res;
    }
}
