package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindDuplicateElements {

    public static List<Integer> findDuplicates1(int[] arr) {

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (map.get(entry.getKey()) > 1)
                list.add(entry.getKey());
        }
        return list;
    }

    public static List<Integer> findDuplicates2(int[] arr) {

        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num))
                res.add(num);
            else
                set.add(num);
        }

        return new ArrayList<>(res);

    }

    public static List<Integer> optimisedSolution(int[] arr) {

        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (int num : arr) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }

        return new ArrayList<>(duplicates);
    }

    public static void main(String[] args) {

        int[] arr = new int[] { 1, 2, 3, 4, 2, 5, 7, 7, 3, 3 };

        System.out.println(findDuplicates1(arr));
        System.out.println(findDuplicates2(arr));
        System.out.println(optimisedSolution(arr));
    }

}
