package medium;

import java.util.Arrays;

/**
 * @author siianchan
 * @since 2024/1/18 09:03
 */
public class MinimumRemoval {
    /**
     * 2171. 拿出最少数目的魔法豆
     * 给定一个 正整数 数组 beans ，其中每个整数表示一个袋子里装的魔法豆的数目。
     * 请你从每个袋子中 拿出 一些豆子（也可以 不拿出），使得剩下的 非空 袋子中
     * （即 至少还有一颗 魔法豆的袋子）魔法豆的数目 相等。一旦把魔法豆从袋子中取出，你不能再将它放到任何袋子中。
     * 请返回你需要拿出魔法豆的 最少数目。
     */
    public static void main(String[] args) {
        System.out.println(minimumRemoval(new int[]{4, 1, 6, 5}));
    }

    public static long minimumRemoval(int[] beans) {
        //将数组进行排序
        Arrays.sort(beans);
        long count = 0;
        long max = 0;
        for (int i = 0; i < beans.length; i++) {
            count += beans[i];
            //排完序后，遍历一遍
            //假如以某个值为基准，那么比这个值小的数全部都要抛弃，比这个值大的部分也要抛弃，哪最终剩的就是这个数*他右边的个数
            //然后记录最小值就是最优解
            max = Math.max(max, (beans.length - i) * (long) beans[i]);
        }
        return count - max;
    }
}
