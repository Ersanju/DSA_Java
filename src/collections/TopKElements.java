package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKElements {

    public static List<Integer> topKElements(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : arr) {
            pq.add(num);
        }

        while (pq.size() > k)
            pq.poll();

        return new ArrayList<>(pq);
    }

    public static void main(String[] args) {

        int[] arr = new int[] { 1, 4, 7, 3, 2, 7, 4, 9, 4, 5 };
        System.out.println(topKElements(arr, 2));
    }

}