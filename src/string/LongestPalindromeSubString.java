package string;

public class LongestPalindromeSubString {

    public static String longestPalindromeString(String str) {

        if (str == null || str.isEmpty())
            return null;

        int start = 0;
        int end = 0;
        for (int i = 0; i < str.length(); i++) {

            int len1 = expandAroundCenter(str, i, i);

            int len2 = expandAroundCenter(str, i, i + 1);

            int maxLength = Math.max(len1, len2);

            if (maxLength > end - start) {
                start = i - (maxLength - 1) / 2;
                end = i + maxLength / 2;
            }
        }

        return str.substring(start, end + 1);
    }

    private static int expandAroundCenter(String str, int start, int end) {

        while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {

            start--;
            end++;
        }
        return end - start - 1;
    }

    public static void main(String[] args) {

        String str = "babccbad";

        System.out.println(longestPalindromeString(str));
    }

}
