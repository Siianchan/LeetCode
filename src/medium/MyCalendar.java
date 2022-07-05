package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2022/7/5 14:57
 * @Description:
 */
public class MyCalendar {

    //    729. 我的日程安排表 I
//    实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。
//    当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 重复预订 。
//    日程可以用一对整数 start 和 end 表示，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end 。
//    实现 MyCalendar 类：
//    MyCalendar() 初始化日历对象。
//    boolean book(int start, int end) 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true 。否则，返回 false 并且不要将该日程安排添加到日历中。
    int[] s = new int[1000];
    int[] e = new int[1000];
    int num = 0;

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        for (int x = 0; x < num && x < 1000; x++) {
            if (start < e[x]) {
                if (end > s[x]) {
                    return false;
                }
            }
        }
        s[num] = start;
        e[num] = end;
        num++;
        return true;
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(1, 2));
        System.out.println(myCalendar.book(2, 5));
        System.out.println(myCalendar.book(3, 6));
    }
}
