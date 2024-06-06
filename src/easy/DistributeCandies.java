package easy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author siianchan
 * @since 2024/6/3 11:05
 */
public class DistributeCandies {
    public static void main(String[] args) {
        new DistributeCandies().distributeCandies(10,2);
    }
    public int[] distributeCandies(int candies, int num_people) {
        int[] nums = new int[num_people];
        int arr = 0;
        int n = 1;
        while (candies > 0) {
            if (candies < n) {
                nums[arr] += candies;
                break;
            } else {
                nums[arr] += n;
                arr++;
                if (arr == num_people) {
                    arr = 0;
                }
                candies-=n;
                n++;
            }

        }

        System.out.println( Arrays.toString(nums));
        return nums;
    }
}
