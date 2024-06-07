package medium;

/**
 * @author siianchan
 * @since 2024/6/6 14:15
 */
public class MinimumSteps {
    /**
     * 桌子上有 n 个球，每个球的颜色不是黑色，就是白色。
     * 给你一个长度为 n 、下标从 0 开始的二进制字符串 s，其中 1 和 0 分别代表黑色和白色的球。
     * 在每一步中，你可以选择两个相邻的球并交换它们。
     * 返回「将所有黑色球都移到右侧，所有白色球都移到左侧所需的 最小步数」。
     */
    public static void main(String[] args) {

        System.out.println(minimumSteps("001"));
    }

    public static long minimumSteps(String s) {
        long count = 0;
        char[] ch = s.toCharArray();
        int a2 = 1;
        for (int x = 0; x < ch.length; x++) {
            if (ch[x] == '1') {
                //和最近的0进行交换
                while (a2 < ch.length && ch[a2] == '1') {
                    a2++;
                }
                if (a2 == ch.length) {
                    break;
                } else {
                    ch[a2] = '1';
                    ch[x] = '0';
                    count += a2 - x;
                }
            } else {
                a2++;
            }
        }
        return count;
    }
}
