package collections;

public class MaximumSubArray {

    public static int maximumSubArray(int[] arr) {

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);

            if (sum < 0)
                sum = 0;
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        System.out.println(maximumSubArray(arr));
    }

}
