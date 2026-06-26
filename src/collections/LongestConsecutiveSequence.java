package collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class LongestConsecutiveSequence {

    // O(N log N) Sorting Approach
    public static int longestConsecutiveSequence(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        Arrays.sort(arr);
        int max = 1;
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                continue;
            }
            if (arr[i] == arr[i - 1] + 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        return Math.max(max, count);
    }

    // O(N log N) PriorityQueue Approach
    public static int longestConsecutiveSequencePQ(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        Queue<Integer> pq = new PriorityQueue<>();
        for (int num : arr) {
            pq.offer(num);
        }

        int max = 1;
        int count = 1;
        int prev = pq.poll();

        while (!pq.isEmpty()) {
            int current = pq.poll();

            if (current == prev) {
                continue;
            }
            if (current == prev + 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
            prev = current;
        }
        return Math.max(max, count);
    }

    public static int longestConsecutiveSequenceHashSet(int[] arr) {

        Set<Integer> set = new HashSet<>();

        for (int num : arr)
            set.add(num);

        int longest = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int length = 1;

                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 2, 10, 11, 12 };

        System.out.println(longestConsecutiveSequence(arr));
        System.out.println(longestConsecutiveSequencePQ(arr));
        System.out.println(longestConsecutiveSequenceHashSet(arr));
    }
}