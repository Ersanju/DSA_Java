package streams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterFrequency {

    public static Map<Character, Long> characterFreq(String str){
        Map<Character, Long> freqMap = str.chars()
                                            .mapToObj(c -> (char)c)
                                            .collect(Collectors.groupingBy(
                                                Function.identity(),
                                                LinkedHashMap :: new,
                                                Collectors.counting()
                                            ));
        return freqMap;
    }

    public static void main(String[] args) {
        String str = "programming";
        System.out.println(characterFreq(str));

    }
    
}
