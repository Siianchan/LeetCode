package medium;

import java.util.Arrays;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/10/27 12:42
 * @Description:
 */
public class QuickSort {
    //快速排序
    public static void main(String[] args) {
        int a[] = {2, 1, 6, 5, 3, 4, 4, 5};
        //4 5 4 6
//        quickSort(a, 0, a.length - 1);
        f(a);
System.out.println(f2("hello"));
//        insertSort(a);
        for (int x = 0; x < a.length; x++) {
            System.out.println(a[x]);
        }
    }

    public static void f(int a[]) {
        for (int x = 0; x < a.length; x++) {
            for (int y = 0; y < a.length - x - 1; y++) {
                if (a[y] > a[y + 1]) {
                    int temp = a[y];
                    a[y] = a[y + 1];
                    a[y + 1] = temp;
                }
            }
        }
    }

    public static String f2(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static void selectSort(int a[]) {
        //选择排序，每次选择一个最小的数，和前面进行交换
        for (int x = 0; x < a.length; x++) {
            int min = Integer.MAX_VALUE;
            int minArr = 0;
            for (int y = x; y < a.length; y++) {
                if (a[y] < min) {
                    min = a[y];
                    minArr = y;
                }
            }
            int temp = a[x];
            a[x] = a[minArr];
            a[minArr] = temp;
        }
    }

    public static void insertSort(int a[]) {
        //插入排序,每个数和前面已经拍好序的数进行比较，然后插入
        for (int x = 1; x < a.length; x++) {
            for (int y = x; y > 0; y--) {
                if (a[y] < a[y - 1]) {
                    int temp = a[y - 1];
                    a[y - 1] = a[y];
                    a[y] = temp;
                }
            }
        }
    }

    public static void quickSort(int a[], int left, int right) {
        //快速排序，选择数组第一位为基准，建立两个指针，
        // 从后边指针开始往前查找比基准小的，然后交换，然后从前边指针开始查找，然后交换。然后分治，递归调用
        if (left >= right) return;//当两指针相交时，返回
        int base = a[left]; //定义基准值
        int i = left, j = right; //左右指针
        while (i < j) {
            while (i < j) {//先从末尾开始，搜寻比基准值小的数
                if (a[j] < base) { //当右指针搜索到小于基准值的时候
                    a[i] = a[j];//将搜寻到的值赋值到左指针
                    i++;//左指针++
                    break;
                }
                j--;//没搜寻到，继续往前搜索
            }
            while (i < j) {
                if (a[i] > base) {//同上，右指针搜寻完之后开始搜寻左指针
                    a[j] = a[i];
                    j--;
                    break;
                }
                i++;
            }
        }
        a[i] = base;//将基准值填充到所在位置
//        System.out.println("i=" + i);
//        for (int x = 0; x < a.length; x++) {
//            System.out.print(a[x] + "=");
//        }
//        System.out.println();
        quickSort(a, left, i - 1);//递归继续处理剩下的左边
        quickSort(a, j + 1, right);//递归继续处理剩下的右边
    }
}
