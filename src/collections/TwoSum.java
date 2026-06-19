package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TwoSum {

    // Wrong solution arr = 1,2,3,4 tar = 5
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

    public static int[] optimisedSolution(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }

    public static void main(String[] args) {

        int target = 5;
        int[] arr = new int[] { 1, 2, 3, 4 };

        System.out.println(twoSum(arr, target));
        int[] res = optimisedSolution(arr, target);
        for (int num : res)
            System.out.println(num);
    }

}
