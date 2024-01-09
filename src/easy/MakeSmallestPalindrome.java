package easy;

import java.util.Arrays;

/**
 * @author siianchan
 * @since 2023/12/13 09:50
 */
public class MakeSmallestPalindrome {

    public static void main(String[] args) {
        System.out.println(new MakeSmallestPalindrome().makeSmallestPalindrome("bv"));
    }

    public String makeSmallestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while (l < r) {
            if (chars[l] != chars[r]) {
                char temp = (char) Math.min(chars[l], chars[r]);
                chars[l] = temp;
                chars[r] = temp;
            }
            l++;
            r--;
        }
        return String.valueOf(chars);
    }
}
