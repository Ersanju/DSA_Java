package string;

public class CheckPalindrome {

    public static boolean checkPalindrome(String str) {
        str = str.toLowerCase();
        String s = "";
        for (char ch : str.toCharArray()) {
            s = ch + s;
        }
        if (str.equals(s))
            return true;
        return false;
    }

    // String Builder
    public static boolean checkPalindrome2(String str) {

        str = str.toLowerCase();
        StringBuilder s = new StringBuilder();
        for (char ch : str.toCharArray()) {
            s.append(ch);
        }
        s.reverse();
        System.out.println(s + " " + str);
        if (str.equals(s.toString()))
            return true;
        return false;
    }

    // String Builder reverse method
    public static boolean checkPalindrome3(String str) {
        str = str.toLowerCase();
        StringBuilder s = new StringBuilder(str);
        s.reverse();
        System.out.println(s + " " + str);
        return str.equals(s.toString());
    }

    public static void main(String[] args) {

        String str = "Aabccbaa";
        System.out.println(checkPalindrome3(str));

    }

}
