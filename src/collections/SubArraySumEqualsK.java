package collections;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

    public static int subArraySumEqualsK(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : arr) {
            sum += num;

            if (map.containsKey(sum - target))
                count++;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr = { 2, 4, 2, 2, 2 };

        System.out.println(subArraySumEqualsK(arr, 6));
    }

}
