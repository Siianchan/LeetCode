package medium;

import java.util.Arrays;

/**
 * @author siianchan
 * @since 2024/9/18 13:56
 */
public class LatestTimeCatchTheBus {
    /**
     * 2332. 坐上公交的最晚时间
     * 已解答
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个下标从 0 开始长度为 n 的整数数组 buses ，其中 buses[i] 表示第 i 辆公交车的出发时间。
     * 同时给你一个下标从 0 开始长度为 m 的整数数组 passengers ，其中 passengers[j] 表示第 j 位乘客的到达时间。所有公交车出发的时间互不相同，所有乘客到达的时间也互不相同。
     * 给你一个整数 capacity ，表示每辆公交车 最多 能容纳的乘客数目。
     * 每位乘客都会搭乘下一辆有座位的公交车。如果你在 y 时刻到达，公交在 x 时刻出发，满足 y <= x  且公交没有满，那么你可以搭乘这一辆公交。最早 到达的乘客优先上车。
     * 返回你可以搭乘公交车的最晚到达公交站时间。你 不能 跟别的乘客同时刻到达。
     * 注意：数组 buses 和 passengers 不一定是有序的。
     * 输入：buses = [10,20], passengers = [2,17,18,19], capacity = 2
     * 输出：16
     * 解释：
     * 第 1 辆公交车载着第 1 位乘客。
     * 第 2 辆公交车载着你和第 2 位乘客。
     * 注意你不能跟其他乘客同一时间到达，所以你必须在第二位乘客之前到达。
     */
    public static void main(String[] args) {
        System.out.println(new LatestTimeCatchTheBus().latestTimeCatchTheBus(new int[]{6, 8, 18, 17}, new int[]{6, 8, 17}, 1));
    }

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        //模拟法
        int c = capacity;
        int parr = 0;
        Arrays.sort(buses);
        Arrays.sort(passengers);
        for (int arrive : buses) {
            c = capacity;
            while (c > 0 && parr < passengers.length && passengers[parr] <= arrive) {
                c--;
                parr++;
            }
        }
        //如果c==0说明坐满了，从最后一个乘客往前找
        //没坐满就从最后一个时间点往前找
        parr--;
        int ret = c > 0 ? buses[buses.length - 1] : passengers[parr];
        while (parr >= 0 && passengers[parr] == ret) {
            ret--;
            parr--;
        }
        return ret;
    }

}
