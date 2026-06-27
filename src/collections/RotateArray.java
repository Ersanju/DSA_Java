package collections;

import java.util.Arrays;
import java.util.List;

public class RotateArray {

    public static List<Integer> rotateArray(int[] arr, int k) {

        int n = arr.length;
        if (arr == null || n == 0)
            return List.of();

        // Handle cases where k is larger than the array length
        k = k % n;

        int[] temp = new int[k];

        // index calculation for temp array
        for (int i = n - k; i < n; i++) {
            temp[i - (n - k)] = arr[i];
        }

        // start shifting from the last element that needs to move
        for (int i = n - k - 1; i >= 0; i--) {
            arr[i + k] = arr[i];
        }

        // Copy elements from temp back to the front
        for (int i = 0; i < k; i++) {
            arr[i] = temp[i];
        }

        return Arrays.stream(arr).boxed().toList();
    }

    public static void reverse(int[] arr, int i, int j) {

        while (i < j) {

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static List<Integer> rotateArrayReverse(int[] arr, int k) {

        int n = arr.length;
        if (arr == null || n == 0)
            return null;

        // k = k % n;
        reverse(arr, 0, n - k - 1);
        reverse(arr, n - k, n - 1);
        reverse(arr, 0, n - 1);

        return Arrays.stream(arr).boxed().toList();
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5, 6, 7 };
        int[] arr2 = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println(rotateArray(arr1, 3));
        System.out.println(rotateArrayReverse(arr2, 3));
    }
}
