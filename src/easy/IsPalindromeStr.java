package easy;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/9/16 14:23
 * @Description:
 */
public class IsPalindromeStr {
    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     */
    public static void main(String[] args) {

    }

    public boolean isPalindrome(String s) {
        char[] ch = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int x = 0; x < ch.length; x++) {
            if ((ch[x] >= 'a' && ch[x] <= 'z') || (ch[x] >= 'A' && ch[x] <= 'Z') || (ch[x] >= '0' && ch[x] <= '9')) {
                stringBuilder.append(String.valueOf(ch[x]));
            }
        }
        String str1 = new String(stringBuilder.toString());
        String str2 = new String(stringBuilder.reverse().toString());
        return str1.toLowerCase().equals(str2.toLowerCase());
    }
}
