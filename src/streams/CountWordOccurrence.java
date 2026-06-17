package streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountWordOccurrence {

    public static Map<String, Long> countOccurrences1(String word){
        Map<String, Long> result = Arrays.stream(word.split(" "))
                                        .collect(Collectors.groupingBy(
                                            Function.identity(),
                                            LinkedHashMap::new,
                                            Collectors.counting()
                                        ));
        return result;
    }

    public static Map<String, Long> countOccurrences2(String[] words){
        Map<String, Long> result = Arrays.stream(words)
                                        .collect(Collectors.groupingBy(
                                            Function.identity(),
                                            LinkedHashMap::new,
                                            Collectors.counting()
                                        ));
        return result;
    }

    public static void main(String[] args) {
        String str = "Java java spring aws java spring spring abc abc abc abc abc";
        System.out.println(countOccurrences1(str));
        String[] words = {"Java", "java", "spring", "aws", "java", "spring", "abc", "abc", "abc", "abc", "abc"};
        System.out.println(countOccurrences2(words));
    }
    
}
