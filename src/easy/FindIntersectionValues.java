package easy;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author siianchan
 * @since 2024/7/16 09:51
 */
public class FindIntersectionValues {
    public static void main(String[] args) {

    }

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map1.containsKey(nums1[i])) {
                map1.put(nums1[i], map1.get(nums1[i]) + 1);
            } else {
                map1.put(nums1[i], 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map2.containsKey(nums2[i])) {
                map2.put(nums2[i], map2.get(nums2[i]) + 1);
            } else {
                map2.put(nums2[i], 1);
            }
        }
        AtomicInteger ret1 = new AtomicInteger(0);
        AtomicInteger ret2 = new AtomicInteger(0);
        map1.forEach((k, v) -> {
            if (map2.containsKey(k)) {
                ret1.addAndGet(v);
                ret2.addAndGet(map2.get(k));
            }
        });
        return new int[]{ret1.get(), ret2.get()};
    }
}
