package easy;

import java.util.Arrays;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2019-12-07 19:17
 * @Description:
 */
public class PlusOne {
    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * 示例 1:
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     */
    public static void main(String args[]) {
        int[] a = new int[]{8, 8, 9, 9, 9, 9};
        System.out.println(Arrays.toString(plusOne(a)));
    }

    public static int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] != 9) {
            //如果最后一位不等于9的话，说明加1不可能进位，直接返回
            digits[digits.length - 1]++;
            return digits;
        }
        for (int x = digits.length - 1; x >= 0; x--) {
            if (++digits[x] > 9) {
                //如果这一组加上一大于9的话，说明要进一位
                digits[x] = 0;
                if (x == 0) {
                    //如果在第一位仍有进位，扩充数组
                    int[] arrs = new int[digits.length + 1];
                    System.arraycopy(digits, 0, arrs, 1, digits.length);
                    arrs[0] = 1;
                    return arrs;
                }
                continue;
            }
            //没进位就直接退出，返回原数组加一的结果
            break;
        }
        return digits;
    }
}
