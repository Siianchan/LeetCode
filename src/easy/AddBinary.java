package easy;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2020-06-01 09:24
 * @Description:
 */
public class AddBinary {

    /**
     * 二进制求和
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。
     * 输入为 非空 字符串且只包含数字 1 和 0。
     * 示例 1:
     * 输入: a = "11", b = "1"
     * 输出: "100"
     */
    public static void main(String args[]) {
        // 22   0
//        System.out.println(addBinary("101011111111", "1011"));
    }
    public static String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        if (b.length() > a.length()) {
            String c = a;
            a = b;
            b = c;
        }
        StringBuilder str = new StringBuilder();
        char[] ch1 = a.toCharArray();
        char[] ch2 = b.toCharArray();
        boolean flag = false;
        for (int x = 0; x < ch1.length; x++) {
            if (x >= ch2.length) {
                int num = ch1[x] - '0';
                if (flag) {
                    num++;
                    if (num > 1) {
                        str.insert(0, num - 2);
                    } else {
                        str.insert(0, num);
                        flag = false;
                    }
                } else {
                    str.insert(0, num);
                }
                continue;
            }
            int num = ch1[x] - '0' + ch2[x] - '0';
            num = flag ? num + 1 : num;
            if (num > 1) {
                str.insert(0, num - 2);
                flag = true;
            } else {
                str.insert(0, num);
                flag = false;
            }
        }
        if (flag) {
            str.insert(0, 1);
        }
        return str.toString();
    }
}
