package easy;

/**
 * @author zxq
 * @since 2024/11/12 13:59
 */
public class CountKConstraintSubstrings {
    /**
     * 3258. 统计满足 K 约束的子字符串数量 I
     * 已解答
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个 二进制 字符串 s 和一个整数 k。
     * 如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束：
     * 字符串中 0 的数量最多为 k。
     * 字符串中 1 的数量最多为 k。
     * 返回一个整数，表示 s 的所有满足 k 约束 的
     * 子字符串
     * 的数量。
     */
    public int countKConstraintSubstrings(String s, int k) {
        int ret = s.length();
        char[] ch = s.toCharArray();
        int[] count = new int[2];
        for (int i = 0; i < ch.length - 1; i++) {
            count[ch[i] - '0']++;
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[j] == '0') {
                    count[0]++;
                } else {
                    count[1]++;
                }
                if (count[0] <= k || count[1] <= k) {
                    ret++;
                } else {
                    break;
                }
            }
            count[0] = 0;
            count[1] = 0;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new CountKConstraintSubstrings().countKConstraintSubstrings("11111", 1));
    }
}
