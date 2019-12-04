package easy;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2019-12-04 20:41
 * @Description:
 */
public class RomanToInt {
    /**
     * 罗马数字转整数
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     */
    public static void main(String args[]) {
            System.out.println(romanToInt("LVIII"));
    }

    public  static  int romanToInt(String s) {
        char[] chs = s.toCharArray();
        int[] nums = new int[chs.length];
        int sum = 0;
        for (int x = 0; x < chs.length; x++) {
            //将字符串先转为数字
            switch (chs[x]) {
                case 'I':
                    nums[x] = 1;
                    break;
                case 'V':
                    nums[x] = 5;
                    break;
                case 'X':
                    nums[x] = 10;
                    break;
                case 'L':
                    nums[x] = 50;
                    break;
                case 'C':
                    nums[x] = 100;
                    break;
                case 'D':
                    nums[x] = 500;
                    break;
                case 'M':
                    nums[x] = 1000;
                    break;
                default:
                    nums[x] = 0;
            }
        }
        if(nums.length==1){
            return nums[0];
        }
        for(int x=0;x<nums.length;x++){
            //根据规则处理数字并进行相加
            if(x!=nums.length-1&&nums[x]<nums[x+1]){
                sum+=(nums[x+1]-nums[x]);
                x++;
            }else{
                sum+=nums[x];
            }
        }
        return sum;
    }
}
