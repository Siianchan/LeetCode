package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/12/18 16:59
 * @Description:
 */

/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 * 示例 1：
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 * 输入：n = 11
 * 输出：0
 */

public class FindNthDigit {
    public static void main(String[] args) {
        System.out.println(new FindNthDigit().findNthDigit2(30));
    }

    public int findNthDigit2(int n) {
        int digit = 1;//位数
        long start = 1;//开始
        long count = 9;//总数量
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }

}
