package string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringNonRepChar {

    public static int longestSubstring(String str) {

        Set<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < str.length(); right++) {
            char currentChar = str.charAt(right);

            while (set.contains(currentChar)) {
                set.remove(str.charAt(left));
                left++;
            }

            set.add(currentChar);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String str = "abcabcbbcdsa";

        System.out.println(longestSubstring(str));
    }

}
