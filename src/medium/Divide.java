package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2019-12-27 13:08
 * @Description:
 */
public class Divide {
    /**
     * 两数相除
     * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
     * 返回被除数 dividend 除以除数 divisor 得到的商。
     * 示例 1:
     * 输入: dividend = 10, divisor = 3
     * 输出: 3
     * 示例 2:
     * 输入: dividend = 7, divisor = -3
     * 输出: -2
     */
    public static void main(String args[]) {
        System.out.println(divide(-2147483648, -1));
    }

    public static int divide(int dividend, int divisor) {
        long x = dividend;
        long y = divisor;
        long z=x/y;
        if(z>2147483647){
            z=2147483647;
        }
        return (int)z;
    }
}
