package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2019-12-16 18:58
 * @Description:
 */
public class Convert {
    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     * 请你实现这个将字符串进行指定行数变换的函数：
     * string convert(string s, int numRows);
     */
    public static void main(String args[]) {
        System.out.println(convert("LEETCODEISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[][] ch = new char[numRows][s.length()];
        char[] chs = s.toCharArray();
        int x = 0, y = 0;
        boolean flag = true;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chs.length; i++) {
            if (x == 0) {
                flag = true;
            } else if (x == numRows - 1) {
                flag = false;
            }
            ch[x][y] = chs[i];
            if (flag) {
                x++;
            } else {
                x--;
                y++;
            }
        }
        for (int a = 0; a < ch.length; a++) {
            for (int b = 0; b < ch[a].length; b++) {
                if (ch[a][b] != '\u0000') {
                    stringBuilder.append(ch[a][b]);
                }
            }
        }
        return stringBuilder.toString();
    }
}
