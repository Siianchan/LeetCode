package medium;

import java.math.BigInteger;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/8/2 16:20
 * @Description:
 */
public class StrMultiply {
    /**
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     * 示例 1:
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     * 示例 2:
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     * 说明：
     * num1 和 num2 的长度小于110。
     * num1 和 num2 只包含数字 0-9。
     * num1 和 num2 均不以零开头，除非是数字 0 本身。
     * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
     */

    //解题思路，把num1字符串填入一个二维数组，根据num2的长度依次进位，然后循环num2，将num每一位乘以num1数组，最后汇总做进位处理
    public static void main(String[] args) {
        StrMultiply s = new StrMultiply();
//        System.out.println(s.multiply("2", "3"));
        System.out.println(s.multiply2("999999999", "999999999999"));
    }
    public String multiply2(String num1, String num2) {

        BigInteger integer1=new BigInteger(num1);
        BigInteger integer2=new BigInteger(num2);
        return integer1.multiply(integer2).toString();
    }
    public String multiply(String num1, String num2) {
        // 23 45
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        int[][] ans = new int[num1.length() + num2.length()][num1.length() + num2.length()];
        int[] res = new int[num1.length() + num2.length()];
        for (int x = ch1.length - 1, z = 1; x >= 0; x--, z++) {
            int a = ch1[x] - '0';
            for (int y = 0; y < ch2.length; y++) {
                ans[y][ans.length - z - y] = a;
            }
        }

        for (int x = ch2.length - 1, n = 0; x >= 0; x--, n++) {
            int n1 = ch2[x] - '0';
            for (int y = ans.length - 1 - n; y >= ans.length - (ch1.length + n); y--) {
                //第一步，先乘
                int n2 = ans[n][y];
                int n3 = n1 * n2;
                ans[n][y] = n3;
            }

            for (int y = ans.length - 1 - n; y >= ans.length - (ch1.length + n); y--) {
                //再来一遍循环计算进位
                int num = ans[n][y];
                if (num < 10) {
                    continue;
                } else {
                    ans[n][y] %= 10;
                    ans[n][y - 1] += (num / 10);
                }
            }
        }
        for (int x = ans.length - 1; x >= 0; x--) {
            //把各个位的结果加到同一数组
            int num = 0;
            for (int y = ans[x].length - 1; y >= 0; y--) {
                num += ans[y][x];
            }
            res[x] = num;
        }
        for (int y = res.length - 1; y > 0; y--) {
            //汇总后做进位
            int num = res[y];
            if (num < 10) {
                continue;
            } else {
                res[y] %= 10;
                res[y - 1] += (num / 10);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int y = 0; y < res.length; y++) {
            //答案
            if (stringBuilder.length() == 0 && res[y] == 0) {
                //首位不计0
                continue;
            }
            stringBuilder.append(res[y]);
        }
        return stringBuilder.toString();
    }
}
