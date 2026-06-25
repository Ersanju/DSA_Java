package collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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

    static class HeapNode {
        int arrLabel;
        int val;
        int index;

        HeapNode(int arrLabel, int val, int index) {
            this.arrLabel = arrLabel;
            this.val = val;
            this.index = index;
        }

    }

    public static List<Integer> mergeSortedArrayQ(int[] a, int[] b) {

        List<Integer> res = new ArrayList<>();

        Queue<HeapNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        if (a != null && a.length > 0)
            minHeap.offer(new HeapNode(0, a[0], 0));
        if (b != null && b.length > 0)
            minHeap.offer(new HeapNode(1, b[0], 0));

        while (!minHeap.isEmpty()) {

            HeapNode curr = minHeap.poll();
            res.add(curr.val);
            int nextIndex = curr.index + 1;

            if (curr.arrLabel == 0) {
                if (nextIndex < a.length) {
                    minHeap.offer(new HeapNode(0, a[nextIndex], nextIndex));
                }
            } else {
                if (nextIndex < b.length) {
                    minHeap.offer(new HeapNode(1, b[nextIndex], nextIndex));
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {

        int[] a = new int[] { 1, 3, 5, 7, 8, 9 };
        int[] b = new int[] { 2, 4, 11, 45 };

        System.out.println(mergeSortedArray(a, b));
        System.out.println(mergeSortedArrayQ(a, b));
    }

}
