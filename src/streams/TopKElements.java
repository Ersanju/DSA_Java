package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TopKElements {

    public static List<Integer> topKElements(int[] arr, int k){
        List<Integer> list = Arrays.stream(arr)
                                .boxed()
                                .sorted(Comparator.reverseOrder())
                                .limit(k)
                                .collect(Collectors.toList());
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,2,5,6,36,8,3,2,54,44};
        System.out.println(topKElements(arr, 4));
    }
    
}
