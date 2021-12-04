package easy;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/11/1 16:16
 * @Description:
 */
public class HammingWeight {
<<<<<<< HEAD
=======

>>>>>>> 7f83cc16531a5f4c9c5a6f23475cdf9c5658f3d6
    public static void main(String[] args){
            hammingWeight(4294967293l);
    }

    public static int hammingWeight(long n) {
        int ret = 0;
        for (; n != 0; n /= 2) {
            if (n % 2 == 1) {
                ret++;
            }
        }
        System.out.println(ret);
        return ret;
    }

}
