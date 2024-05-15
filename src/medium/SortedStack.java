package medium;

import java.util.LinkedList;

/**
 * @author siianchan
 * @since 2024/5/15 17:15
 */
public class SortedStack {

    /**
     * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。
     * 该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
     */
    public static void main(String[] args) {
        SortedStack s = new SortedStack();
        s.push(5);
        s.push(2);
        s.push(1);
        s.push(3);
        System.out.println(s.peek());
    }


    LinkedList<Integer> l1 = new LinkedList<>();
    LinkedList<Integer> l2 = new LinkedList<>();


    public SortedStack() {

    }

    public void push(int val) {
        //push的时候做检查，如果当前栈顶元素小于当前元素的话，循环出栈，
        // 直到为空或者小于，然后push该元素，最后将出栈的元素push回去
        if (l1.isEmpty()) {
            l1.push(val);
        } else {
            while (!l1.isEmpty() && l1.peek() < val) {
                l2.push(l1.pop());
            }
            l1.push(val);
            while (!l2.isEmpty()) {
                l1.push(l2.pop());
            }
        }
    }

    public void pop() {
        if (!l1.isEmpty())
            l1.pop();
    }

    public int peek() {
        if (!l1.isEmpty()) {
            return l1.peek();
        } else {
            return -1;
        }
    }

    public boolean isEmpty() {
        return l1.isEmpty();
    }
}
