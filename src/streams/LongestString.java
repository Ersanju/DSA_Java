package streams;

import java.util.Arrays;
import java.util.Comparator;

public class LongestString {

    public static String longestString(String[] words) {
        String str = Arrays.stream(words)
                .max(Comparator.comparingInt(String::length))
                // .max((s1, s2) -> Integer.compare(s1.length(),s2.length()))
                .orElse(null);
        return str;
    }

    public static Integer longestStringLength(String[] words) {
        Integer res = Arrays.stream(words)
                .mapToInt(String::length)
                .max()
                .orElse(0);
        return res;
    }

    public static void main(String[] args) {
        String[] words = { "java", "Microservices", "Spring", "AWS", "" };
        System.out.println(longestString(words));
        System.out.println(longestStringLength(words));
    }

}
