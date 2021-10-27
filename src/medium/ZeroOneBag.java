package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/10/27 12:28
 * @Description:
 */
public class ZeroOneBag {
    //01背包问题，动态规划
    public static void main(String[] args) {

    }

    public static void dp2() {
        //01背包问题 一维数组
        int[] weight = {77, 22, 29, 50, 99};
        int[] value = {92, 22, 87, 46, 90};
        int[] dp = new int[101];
        for (int x = 0; x < weight.length; x++) {
            //15
            for (int y = dp.length - 1; y >= weight[x]; y--) {
                //注意要逆序从后往前算
                dp[y] = Math.max(dp[y], dp[y - weight[x]] + value[x]);
            }
        }
//        for (int x = 0; x < dp.length; x++)
        System.out.println(dp[100]);
    }

    public static void dp() {
        //01背包问题二维数组
        int[] weight = {77, 22, 29, 50, 99};
        int[] value = {92, 22, 87, 46, 90};
        int[][] dp = new int[weight.length + 1][101];
        for (int x = 1; x <= weight.length; x++) {
            for (int y = 1; y < dp[x].length; y++) {
                if (y < weight[x - 1]) {
                    dp[x][y] = dp[x - 1][y];
                } else {
                    dp[x][y] = Math.max(dp[x - 1][y], dp[x - 1][y - weight[x - 1]] + value[x - 1]);
                }
            }
        }
        System.out.print(dp[5][100] + " ");
//        for (int x = 0; x < dp.length; x++) {
//            for (int y = 0; y < dp[x].length; y++) {
//                System.out.print(dp[x][y] + " ");
//            }
//            System.out.println();
//        }
    }
}
