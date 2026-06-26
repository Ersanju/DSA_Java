package collections;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DailyTemperatures {

    public static List<Integer> nextWarmerDay(int[] temperatures) {

        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }

        return Arrays.stream(res).boxed().toList();
    }

    public static void main(String[] args) {

        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };

        System.out.println(nextWarmerDay(temperatures));
    }

}
