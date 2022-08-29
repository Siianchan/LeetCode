package medium;

import java.util.*;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2022/8/29 9:42
 * @Description:
 */
public class AlertNames {
    /**
     * 1604. 警告一小时内使用相同员工卡大于等于三次的人
     * 力扣公司的员工都使用员工卡来开办公室的门。每当一个员工使用一次他的员工卡，
     * 安保系统会记录下员工的名字和使用时间。如果一个员工在一小时时间内使用员工卡的次数大于等于三次，这个系统会自动发布一个 警告 。
     * 给你字符串数组 keyName 和 keyTime ，其中 [keyName[i], keyTime[i]] 对应一个人的名字和他在 某一天 内使用员工卡的时间。
     * 使用时间的格式是 24小时制 ，形如 "HH:MM" ，比方说 "23:51" 和 "09:49" 。
     * 请你返回去重后的收到系统警告的员工名字，将它们按 字典序升序 排序后返回。
     * 请注意 "10:00" - "11:00" 视为一个小时时间范围内，而 "23:51" - "00:10" 不被视为一小时内，因为系统记录的是某一天内的使用情况。
     */
    public static void main(String[] args) {
        String[] ketName = new String[]{"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"};
        String[] keyTime = new String[]{"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"};
        AlertNames alertNames = new AlertNames();
        System.out.println(alertNames.alertNames(ketName, keyTime));
    }

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> result = new ArrayList<>();
        HashMap<String, List> hashMap = new HashMap<>();
        for (int x = 0; x < keyName.length; x++) {
            if (result.contains(keyName[x])) {
                continue;
            }
            if (hashMap.get(keyName[x]) == null) {
                List<String> time = new ArrayList();
                time.add(keyTime[x]);
                hashMap.put(keyName[x], time);
            } else {
                List<String> keyTimelist = hashMap.get(keyName[x]);
                keyTimelist.add(keyTime[x]);
                if (keyTimelist.size() >= 3) {
                    if (check(keyTimelist)) {
                        result.add(keyName[x]);
                    }
                }
            }
        }
        Collections.sort(result);
        return result;
    }

    boolean check(List<String> time) {
        int[] num = new int[time.size()];
        int arr = 0;

        for (String string : time
        ) {
            //时间转换成分钟进行换算
            String strs[] = string.split(":");
            int t = Integer.parseInt(strs[0]) * 60 + Integer.parseInt(strs[1]);
            num[arr] = t;
            arr++;
        }
        Arrays.sort(num);
        for (int x = 0; x < num.length - 2; x++) {
            if (num[x + 1] - num[x] <= 60 && num[x + 2] - num[x] <= 60) {
                return true;
            }
        }
        return false;
    }

}
