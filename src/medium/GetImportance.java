package medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author siianchan
 * @since 2024/8/26 15:39
 */
public class GetImportance {
    /**
     * 你有一个保存员工信息的数据结构，它包含了员工唯一的 id ，重要度和直系下属的 id 。
     * 给定一个员工数组 employees，其中：
     * employees[i].id 是第 i 个员工的 ID。
     * employees[i].importance 是第 i 个员工的重要度。
     * employees[i].subordinates 是第 i 名员工的直接下属的 ID 列表。
     * 给定一个整数 id 表示一个员工的 ID，返回这个员工和他所有下属的重要度的 总和
     */
    public static void main(String[] args) {

    }

    Map<Integer, Employee> map = new HashMap<>(1024);

    int total = 0;

    public int getImportance(List<Employee> employees, int id) {
        employees.stream().forEach(tmp -> {
            map.put(tmp.id, tmp);
        });
        dfs(id);
        return total;
    }

    public void dfs(int id) {
        Employee employee = map.get(id);
        total += employee.importance;
        if (employee.subordinates.isEmpty()) {
            return;
        }
        for (int x = 0; x < employee.subordinates.size(); x++) {
            dfs(employee.subordinates.get(x));
        }
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};