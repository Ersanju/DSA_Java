package streams;

import java.util.Arrays;
import java.util.Comparator;

public class SecondHighestNumber {

    public static int secondHighestNumber(int[] arr){
        int res = Arrays.stream(arr)
                        .boxed()
                        .distinct()
                        .sorted(Comparator.reverseOrder())
                        .skip(1)
                        .findFirst()
                        .orElse(-1);
    
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,6,7,5,4,5,7,8,4,3,5,7,9};
        System.out.println(secondHighestNumber(arr));
    }
    
}
