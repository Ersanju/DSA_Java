package streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateElements {

    public static List<Integer> duplicateElements(int[] arr){
        Set<Integer> seen = new HashSet<>();
        List<Integer> duplicates = Arrays.stream(arr)
                                        .boxed()
                                        .filter(n -> !seen.add(n))
                                        .distinct()
                                        .collect(Collectors.toList());
        return duplicates;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,2,4,5,1,1};
        System.out.println(duplicateElements(arr).toString());
    }
    
}
