package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] words) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {

            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        String[] words = new String[] { "abc", "cab", "bac", "xyz", "zyx", "pqr" };

        System.out.println(groupAnagrams(words));
    }

}
