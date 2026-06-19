package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckAnagram {

    public static boolean checkAnagram1(String a, String b) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : a.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (char c : b.toCharArray()) {

            if (!map.containsKey(c))
                return false;

            map.put(c, map.get(c) - 1);

            if (map.get(c) < 0)
                return false;
        }

        return true;

    }

    public static boolean checkAnagram2(String a, String b) {

        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        String str1 = new String(arr1);
        String str2 = new String(arr2);

        return str1.equals(str2);

    }

    public static boolean optimisedSolution(String a, String b) {

        if (a == null || b == null)
            return false;

        if (a.length() != b.length())
            return false;

        int[] freq = new int[256];

        for (char c : a.toCharArray())
            freq[c]++;

        for (char c : b.toCharArray())
            freq[c]--;

        for (int count : freq)
            if (count != 0)
                return false;

        return true;
    }

    public static void main(String[] args) {

        String a = "Java";
        String b = "aaJv";

        System.out.println(checkAnagram1(a, b));
        System.out.println(checkAnagram2(a, b));
        System.out.println(optimisedSolution(a, b));
    }

}
