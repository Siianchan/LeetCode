package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2019-12-17 17:04
 * @Description:
 */
public class MaxArea {
    /**
     * 盛最多水的容器
     * 给定 n
     * 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n
     * 条垂直线，
     * 垂直线 i 的两个端点分别为 (i, ai)
     * 和(i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     * 示例:
     * 输入:[1,8,6,2,5,4,8,3,7]
     * 输出:49
     */

    public static void main(String args[]) {
        int[] a = new int[]{7, 22,22,7};
        System.out.println(maxArea(a));
    }

    public static int maxArea(int[] height) {
        //双指针算法，将两个指针分别位于数组开头和结尾位置。
        //将y轴短的一方向另一方移动，同时检验是否最大值
        int area = 0;
        int a = 0, b = height.length - 1;
        int s;
        while (a != b) {
            if (height[a] < height[b]) {
                //如果左边比右边短，记录面积后向右移动一格
                s = height[a] * (b - a);
                area = s > area ? s : area;
                a++;
            } else {
                //如果右边比左边短，记录面积后向左移动一格
                s = height[b] * (b - a);
                area = s > area ? s : area;
                b--;
            }
        }
        return area;
    }
}
