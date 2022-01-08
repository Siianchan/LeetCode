package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2022/1/8 16:37
 * @Description:
 */
public class ConstructArr {
    /**
     * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
     * 其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
     * 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
     * 示例:
     * 输入: [1,2,3,4,5]
     * 输出: [120,60,40,30,24]
     */

    public static void main(String[] args) {

    }

    public int[] constructArr(int[] a) {
        //答案数组b[i]为i左边的全部乘积，再乘上i右边的乘积
        if (a.length < 1) return a;
        int[] b = new int[a.length];
        b[0] = 1;
        for (int x = 1; x < a.length; x++) {
            //第一遍循环，算出b[i]的左边全部乘积，存入b[]中
            b[x] = b[x - 1] * a[x - 1];
        }
        int temp = 1;
        for (int x = a.length - 1; x >= 0; x--) {
            //第二遍循环。从右边开始，算出b[i-1]*右边全部乘积的答案，存入b[i]中，最终b[]为答案
            b[x] = b[x] * temp;
            //temp记录右边全部乘积,初始为1
            temp *= a[x];
        }
        return b;
    }
}
