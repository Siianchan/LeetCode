package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/12/25 14:12
 * @Description:
 */

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 示例 1：
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 */

public class SingleNumbers {
    public static void main(String[] args) {
        SingleNumbers singleNumbers = new SingleNumbers();
        singleNumbers.singleNumbers(new int[]{4, 8, 4, 6});
    }

    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int c : nums
        ) {
            ret ^= c;
        }
        //先对数组进行异或操作，得出的结果是两个不同数字的异或结果
        int h = 1;
        while ((ret & h) == 0) {
            //找出结果的第一位为1的数字
            h <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums
        ) {
            if ((h & n) == 0) {
                //对数据进行分组，将两个不同的数字分到两个组，异或操作就能得到最后结果了
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}
