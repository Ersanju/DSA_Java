package collections;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

    public static int topKthElement(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : arr) {
            pq.add(num);
        }

        while (pq.size() > k)
            pq.poll();

        return pq.peek();
    }

    public static List<Integer> topKFrequentElements(int[] arr, int k) {

        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        pq.addAll(map.keySet());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(pq.poll());
        }
        return list;
    }

    public static void main(String[] args) {

        int[] arr = new int[] { 1, 4, 7, 3, 2, 7, 4, 9, 4, 5 };
        System.out.println(topKElements(arr, 2));
        System.out.println(topKthElement(arr, 2));
        System.out.println(topKFrequentElements(arr, 2));
    }

}