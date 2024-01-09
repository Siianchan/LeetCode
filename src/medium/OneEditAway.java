package medium;

/**
 * @author siianchan
 * @since 2024/1/9 16:37
 */
public class OneEditAway {
    /**
     * 字符串有三种编辑操作:插入一个英文字符、删除一个英文字符或者替换一个英文字符。
     * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
     * 输入:
     * first = "pale"
     * second = "ple"
     * 输出: True
     */
    public static void main(String[] args) {
        System.out.println(oneEditAway("abc", "ac"));
    }

    public static boolean oneEditAway(String first, String second) {
        if (first.length() < second.length()) {
            String temp = first;
            first = second;
            second = temp;
        }
        int d = first.length() - second.length();
        if (d > 1) {
            return false;
        }
        char[] c1 = first.toCharArray();
        char[] c2 = second.toCharArray();
        boolean change = false;
        for (int x = 0, y = 0; x < first.length() && y < second.length(); x++, y++) {
            if (c1[x] != c2[y]) {
                if (change) {
                    return false;
                }
                if (d != 0) {
                    //如果数量不一致，当做是这里插入了字符，将y停滞一位;
                    y--;
                }
                change = true;
            }
        }
        return true;
    }
}
