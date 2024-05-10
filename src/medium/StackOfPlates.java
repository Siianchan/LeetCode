package medium;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author siianchan
 * @since 2024/5/10 09:57
 */
public class StackOfPlates {
    public static void main(String[] args) {
        StackOfPlates s = new StackOfPlates(1);
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.data);
        System.out.println(s.popAt(1));
        System.out.println(s.data);
        s.pop();
//        s.pop();
        s.pop();
    }

    int cap = 0;

    ArrayList<LinkedList<Integer>> data = new ArrayList<>();

    public StackOfPlates(int cap) {
        this.cap = cap;
    }


    public void push(int val) {
        if (data.isEmpty()) {
            addNewList(val);
        } else {
            LinkedList var = data.get(data.size() - 1);
            if (var.size() == cap) {
                addNewList(val);
            } else {
                var.push(val);
            }
        }
    }

    private void addNewList(int val) {
        LinkedList var = new LinkedList();
        var.push(val);
        data.add(var);
    }

    public int pop() {
        if (cap == 0 || data.isEmpty()) {
            return -1;
        } else {
            LinkedList<Integer> var = data.get(data.size() - 1);
            int ret = var.pop();
            if (var.isEmpty()) {
                data.remove(var);
            }
            return ret;
        }
    }

    public int popAt(int index) {
        if (cap == 0 || data.isEmpty() || index >= data.size()) {
            return -1;
        }
        LinkedList<Integer> var = data.get(index);
        int ret = var.pop();
        if (var.isEmpty()) {
            data.remove(var);
        }
        return ret;
    }
}
