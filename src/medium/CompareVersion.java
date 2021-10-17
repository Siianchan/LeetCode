package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/10/14 16:39
 * @Description:
 */
public class CompareVersion {
    
    /**
     * 给你两个版本号 version1
     * 和 version2 ，请你比较它们。
     * 版本号由一个或多个修订号组成，各修订号由一个 '.'连接。
     * 每个修订号由 多位数字
     * 组成，
     * 可能包含 前导零 。每个版本号至少包含一个字符。
     * 修订号从左到右编号，下标从 0开始，最左边的修订号下标为 0 ，
     * 下一个修订号下标为 1 ，以此类推。例如，2.5.33和 0.1都是有效的版本号。
     * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。
     * 返回规则如下：
     * 如果 version1 > version2 返回 1，
     * 如果 version1 < 
     * version2 返回 -1，
     * 除此之外返回 0。
     */

    public static void main(String[] args) {
        CompareVersion compareVersion = new CompareVersion();
        compareVersion.compareVersion("0.1", "1.1");
    }

    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        for (int x = 0; x < ver1.length || x < ver2.length; x++) {
            int a = 0, b = 0;
            if (x < ver1.length) {
                a = Integer.parseInt(ver1[x]);
            }
            if (x < ver2.length) {
                b = Integer.parseInt(ver2[x]);
            }
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            } else {
                if (x == ver1.length && x == ver2.length) {
                    return 0;
                }
            }
        }
        return 0;
    }
}
