package easy;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/11/1 16:16
 * @Description:
 */
public class HammingWeight {
<<<<<<< HEAD
    public static void main(String[] args) {
        test();
=======

    public static void main(String[] args){
            hammingWeight(4294967293l);
>>>>>>> Golang
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

    public static void test() {
        long a=System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            i += 1;
        }
        System.out.println(System.currentTimeMillis()-a);
    }

}
