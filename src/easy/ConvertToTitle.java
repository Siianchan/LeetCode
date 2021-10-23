package easy;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/10/21 16:44
 * @Description:
 */
public class ConvertToTitle {

    /**
     * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
     * 例如：
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * ...
     */

    public static void main(String[] args) {
        ConvertToTitle convertToTitle = new ConvertToTitle();
        System.out.println(convertToTitle.convertToTitle(27));
    }


    public String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        while (columnNumber > 0) {
            int yu = (columnNumber - 1) % 26 + 1;//偏移一位方便计算26
            stringBuilder.insert(0, String.valueOf((char) ('A' + yu - 1)));
            columnNumber -= yu;
            columnNumber /= 26;
        }
        return stringBuilder.toString();
    }
}
