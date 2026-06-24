package collections;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedArray {

    public static List<Integer> mergeSortedArray(int[] a, int[] b) {

        List<Integer> list = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                list.add(a[i]);
                i++;
            } else {
                list.add(b[j]);
                j++;
            }
        }
        while (i < a.length) {
            list.add(a[i]);
            i++;
        }
        while (j < b.length) {
            list.add(b[j]);
            j++;
        }

        return list;
    }

    public static void main(String[] args) {

        int[] a = new int[] { 1, 3, 5, 7, 8, 9 };
        int[] b = new int[] { 2, 4, 11, 45 };

        System.out.println(mergeSortedArray(a, b));
    }

}
