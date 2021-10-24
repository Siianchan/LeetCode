package easy;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/10/24 13:34
 * @Description:
 */
public class TitleToNumber {
    /**
     * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。
     * 例如，
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     */

    public static void main(String[] args) {

    }

    public int titleToNumber(String columnTitle) {
        if (columnTitle.trim().length() <= 0) return 0;
        char[] chs = columnTitle.toCharArray();
        int returnNum = 0;
        for (int x = 0; x < chs.length; x++) {
            int n = chs[x] - 'A' + 1;
            returnNum += n * (Math.pow(26, chs.length - x - 1));
        }
        return returnNum;
    }
}
