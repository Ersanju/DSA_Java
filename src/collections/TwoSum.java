package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSum {

    public static List<Integer> twoSum(int[] arr, int target) {

        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            set.add(target - num);
        }
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i]))
                list.add(i);
            if (list.size() == 2)
                break;
        }

        return list;
    }

    public static void main(String[] args) {

        int target = 9;
        int[] arr = new int[] { 2, 5, 7, 5, 7, 3 };

        System.out.println(twoSum(arr, target));
    }

}
