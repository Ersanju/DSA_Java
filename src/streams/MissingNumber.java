package streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingNumber {

    public static int missingNumber(int[] arr, int n){
        int missing = IntStream.rangeClosed(1,n).sum() - Arrays.stream(arr).sum();
        return missing;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,4,6,3,5,2};
        System.out.println(missingNumber(arr, 7));
    }
    
}
