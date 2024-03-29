package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2022/7/7 15:41
 * @Description:
 */
public class ReplaceWords {
    /**
     * 在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。
     * 例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
     * 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。
     * 你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
     * 你需要输出替换之后的句子。
     */

    public String replaceWords(List<String> dictionary, String sentence) {
        dictionary.sort(Comparator.comparing(String::length));
        String[] str = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int x = 0; x < str.length; x++
        ) {

            for (String l : dictionary
            ) {
                if (str[x].startsWith(l)) {
                    str[x] = l;
                    break;
                }
            }

        }
        for (int x = 0; x < str.length; x++
        ) {
            stringBuilder.append(str[x]);
            if (x != str.length - 1)
                stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("catt");
        list.add("cat");
        list.add("bat");
        list.add("rat");
        System.out.println(new ReplaceWords().replaceWords(list, "the cattle was rattled by the battery"));
    }

}
