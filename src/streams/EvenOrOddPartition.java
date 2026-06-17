package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EvenOrOddPartition {

    public static Map<Boolean, List<Integer>> evenOddPartition(int[] arr){
        Map<Boolean, List<Integer>> result = Arrays.stream(arr)
                                                .boxed()
                                                // .distinct()
                                                // .sorted()
                                                .collect(Collectors.partitioningBy(
                                                    num -> num%2 == 0
                                                ));

        return result;
    }

    public static List<Integer> evenNumbers(int[] arr){
        List<Integer> result = Arrays.stream(arr)
                                                .boxed()
                                                .filter( n -> n%2 == 0)
                                                .collect(Collectors.toList());

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,5,5,3,6,7,8,1,6,7,5};
        System.out.println(evenOddPartition(arr));
        System.out.println(evenNumbers(arr));
    }
    
}
