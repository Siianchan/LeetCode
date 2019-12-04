package easy;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2019-12-04 14:18
 * @Description:
 */
public class ReverseInteger {
    /**
     * 整数反转
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * 示例 1:
     * 输入: 123
     * 输出: 321
     * 示例 2:
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * 输入: 120
     * 输出: 21
     */
    public static void main(String args[]) {
        System.out.println(reverse(120));
    }
    public  static  int reverse(int x) {
        //如果是负数，做一个标识
        boolean flag=x>=0?true:false;
        //然后转换为正数
        x=Math.abs(x);
        //进行字符串反转
        StringBuilder stringBuilder=new StringBuilder(String.valueOf(x)).reverse();
        try{
            //如果抛出异常说明反转后超过int值上限
            int num=Integer.valueOf(stringBuilder.toString());
            return flag?num:-num;
        }catch (NumberFormatException e){
            return 0;
        }
    }
}
