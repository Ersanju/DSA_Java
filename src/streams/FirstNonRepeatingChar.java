package streams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingChar {

    public static char firstNonRepeatingChar(String str){
        Map<Character, Long> map = str.chars()
                        .mapToObj(c -> (char)c)
                        .collect(Collectors.groupingBy(
                            Function.identity(),
                            LinkedHashMap::new,
                            Collectors.counting()
                        ));
        for(char c : str.toCharArray()){
            if(map.get(c) == 1)
                return c;
        }
        return '_';
    }

    public static char byStreamOnly(String str){
        Character result = str.chars()
                            .mapToObj(c -> (char)c)
                            .collect(Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting()
                            ))
                            .entrySet()
                            .stream()
                            .filter(entry -> entry.getValue() == 1)
                            .map(Map.Entry::getKey)
                            .findFirst()
                            .orElse(null);

        return result;
    }

    public static void main(String[] args) {
        String str = "swiss";
        System.out.println(firstNonRepeatingChar(str));
        System.out.println(byStreamOnly(str));
    }
    
}
