package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2019-12-18 15:03
 * @Description:
 */
public class IntToRoman {
    /**
     * 整数转罗马数字
     * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
     * 示例 1:
     * 输入: 3
     * 输出: "III"
     */
    public static void main(String args[]) {
        System.out.println(intToRoman(1999));
    }

    public static String intToRoman(int num) {
        char[][] ch = new char[][]{{'I', 'V'}, {'X', 'L'}, {'C', 'D'}, {'M', ' '}};
        int x = 0;
        StringBuilder str = new StringBuilder();
        while (num != 0) {
            //从最后一位开始获取，然后转换为罗马字符
            int a = num % 10;
            if (a == 0) {
                //如果等于0，直接转换到下一位
                num /= 10;
                x++;
                continue;
            }
            if (a < 5) {
                String s = new String();
                if (a == 4) {
                    s += ch[x][0];
                    s += ch[x][1];
                } else {
                    for (int y = 0; y < a; y++) {
                        s += ch[x][0];
                    }
                }
                str.insert(0, s);
            } else {
                a %= 5;
                String s = new String();
                if (a == 4) {
                    s += ch[x][0];
                    s += ch[x + 1][0];
                } else {
                    s += ch[x][1];
                    for (int y = 0; y < a; y++) {
                        s += ch[x][0];
                    }
                }
                str.insert(0, s);
            }
            num /= 10;
            x++;
        }
        return str.toString();
    }
}
