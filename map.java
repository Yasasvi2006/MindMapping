import java.util.*;

public class MapProblems {

    /* ---------- Store Key–Value Pairs ---------- */
    public static Map<Integer, Integer> storeKeyValue(int[] keys, int[] values) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i], values[i]);
        }
        return map;
    }

    /* ---------- Searching in Map ---------- */
    public static boolean searchKey(Map<Integer, Integer> map, int key) {
        return map.containsKey(key);
    }

    /* ---------- Finding Duplicates ---------- */
    public static Set<Integer> findDuplicates(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        Set<Integer> duplicates = new HashSet<>();

        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            if (freq.get(x) == 2) {
                duplicates.add(x);
            }
        }
        return duplicates;
    }
}
