package medium;

import java.util.Stack;

/**
 * @author
 * @since 2023/5/31 16:48
 */
public class MctFromLeafValues {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 15, 5, 2};
        mctFromLeafValues(arr);
    }

    public static int mctFromLeafValues(int[] arr) {
        Stack<Integer> st = new Stack();
        st.push(Integer.MAX_VALUE);
        int mct = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] >= st.peek()) {
                mct += st.pop() * Math.min(st.peek(), arr[i]);
            }
            st.push(arr[i]);
        }
        while (st.size() > 2) {
            mct += st.pop() * st.peek();
        }
        return mct;
    }


}
