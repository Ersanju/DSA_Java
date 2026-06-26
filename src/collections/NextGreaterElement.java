package collections;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {

    public static List<Integer> nextGreaterElement(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        Arrays.fill(res, -1);

        for (int i = 0; i < arr.length; i++) {

            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                int index = stack.pop();
                res[index] = arr[i];
            }
            stack.push(i);
        }

        return Arrays.stream(res).boxed().toList();
    }

    public static void main(String[] args) {

        int[] arr = { 2, 1, 2, 4, 3 };

        System.out.println(nextGreaterElement(arr));
    }

}
