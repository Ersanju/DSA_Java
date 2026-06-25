package collections;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {

        stack.push(value);
        if (minStack.isEmpty() || value <= minStack.peek())
            minStack.push(value);
    }

    public int pop() {

        if (stack.isEmpty())
            throw new RuntimeException("Stack is empty");

        int removed = stack.pop();

        if (removed == minStack.peek())
            minStack.pop();

        return removed;
    }

    public int top() {
        if (stack.isEmpty())
            throw new RuntimeException("Stack is empty");

        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty())
            throw new RuntimeException("Stack is empty");

        return minStack.peek();
    }

    public static void main(String[] args) {

        MinStack stack = new MinStack();

        stack.push(5);
        stack.push(2);
        stack.push(8);

        System.out.println(stack.getMin());

        stack.pop();

        System.out.println(stack.getMin());

        stack.pop();

        System.out.println(stack.getMin());
    }

}
