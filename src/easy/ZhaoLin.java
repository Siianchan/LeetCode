package easy;

import java.util.HashMap;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/10/28 14:47
 * @Description:
 */
public class ZhaoLin {
    /**
     * 一家五元店，每件商品卖5元。
     * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买1件，但是给的钱面额不同，有5元、10元，20元、50元、100元。
     * 你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 元。
     * 假设一开始你手头有2张5元，2张10元。
     * 如果你能给每位顾客正确找零，返回 0 ，否则返回无法找零的顾客顺序号（1-N）
     * 示例 1：
     * Plain Text
     * 复制代码
     * 输入：[10,10,5,50,5,5,5,10,20]
     * 输出：0
     * 解释：
     * 输入数组的数值表示顾客给你的金额
     * 由于所有客户都得到了正确的找零，所以我们输出 0。
     * 示例 2：
     * Plain Text
     * 复制代码
     * 输入：[10,10,5,50,5,20,5,10,20]
     * 输出：6
     * 解释：
     * 输入数组的数值表示顾客给你的金额
     * 由于第6位客户无法找零，所以我们输出 6。
     */

    public static void main(String[] args) {
        int a[] = {10, 10, 5, 50, 5, 5, 5, 10, 20};
        f(a);
    }

    public static void f(int money[]) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        hashMap.put(5, 2);
        hashMap.put(10, 2);
        hashMap.put(20, 0);
        hashMap.put(50, 0);
        hashMap.put(100, 0);
        int n[] = {50, 20, 10, 5};
        for (int x = 0; x < money.length; x++) {
            hashMap.put(money[x], hashMap.get(money[x]) + 1);
            money[x] -= 5;
            for (int y = 0; y < n.length; y++) {
                while (money[x] >= n[y] && hashMap.get(n[y]) > 0) {
                    money[x] -= n[y];
                    hashMap.put(n[y], hashMap.get(n[y]) - 1);
                }
            }
            if (money[x] != 0) {
                System.out.println(x + 1);
                return;
            }
        }
        System.out.println(0);
    }
}
