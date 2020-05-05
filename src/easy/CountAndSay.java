package easy;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2020-05-05 14:06
 * @Description:
 */

/**
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 */
public class CountAndSay {
    public static void main(String args[]) {
        System.out.println(countAndSay(6));
    }

    public static String countAndSay(int n) {
        String str = "1";
        for (int x = 1; x < n; x++) {
            StringBuilder changeStr = new StringBuilder("");
            int num = 0;
            char chstr = str.charAt(0);
            for (char c : str.toCharArray()
            ) {
                if (c == chstr) {
                    num++;
                } else {
                    changeStr.append(num).append(chstr);
                    chstr = c;
                    num = 1;
                }
            }
            //处理尾部
            changeStr.append(num).append(chstr);
            str = changeStr.toString();
        }
        return str;
    }
}
