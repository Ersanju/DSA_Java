package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductOfArrayExceptSelf {

    public static List<Integer> productArray(int[] arr) {

        List<Integer> list = new ArrayList<>();
        int product = 1;
        for (int num : arr) {
            product = product * num;
        }
        for (int num : arr) {
            list.add(product / num);
        }

        return list;
    }

    public static List<Integer> productArraySuffixPrefix(int[] arr) {
        // Edge case: return an empty list if input is empty or null
        if (arr == null || arr.length == 0) {
            return Arrays.asList();
        }

        int[] res = new int[arr.length];

        // Step 1: Prefix products (Must use arr[i - 1], not arr[i])
        res[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            res[i] = res[i - 1] * arr[i - 1];
        }

        // Step 2: Suffix products
        int suffix = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            res[i] = res[i] * suffix;
            suffix = suffix * arr[i];
        }

        // Step 3: Stream conversion
        return Arrays.stream(res)
                .boxed()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        int[] arr = new int[] { 1, 2, 3, 4, 5 };

        System.out.println(productArray(arr));
        System.out.println(productArraySuffixPrefix(arr));
    }

}
