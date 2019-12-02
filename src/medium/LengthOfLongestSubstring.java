package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2019-12-02 13:17
 * @Description:
 */
public class LengthOfLongestSubstring {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * 示例 1:
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */
    public static void main(String args[]) {
        System.out.println(lengthOfLongestSubstring("avc"));
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] ch = s.toCharArray();
        int num = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int x = 0; x < ch.length-num; x++) {
            //从第一个字符开始往后组成字符串，当字符串包含重复字母时开始下一次匹配并记录最长的长度
            int sum = 0;
            for (int y = x; y < ch.length; y++) {
                String str = String.valueOf(ch[y]);
                if (stringBuilder.toString().contains(str)) {
                    num = sum > num ? sum : num;
                    stringBuilder = new StringBuilder();
                    break;
                }
                stringBuilder.append(str);
                sum++;
                if (y == ch.length - 1) {
                    num = sum > num ? sum : num;
                }
            }
        }
        return num;
    }
}
