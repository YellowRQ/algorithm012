import org.junit.Test;

import java.util.*;

/**
 * ClassName:_17LetterCombinations
 * Package:PACKAGE_NAME
 * Description:
 *  给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *  给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *  示例:
 *  输入："23"
 *  输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *  说明:尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *  Related Topics 字符串 回溯算法
 * @author:yellowrq
 * @date: 2020/7/30 17:42
 */
public class _17LetterCombinations {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","hkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
        search("", digits, 0, res, map);
        return res;
    }

    private void search(String s,
                        String digits,
                        int i,
                        List<String> res,
                        Map<String, String> map) {
        if (i == digits.length()) {
            res.add(s);
            return;
        }
        String letters = map.get(digits.charAt(i));
        for (int j = 0; j < letters.length(); j++) {
            search(s + letters.charAt(j), digits, i + 1, res, map);
        }
    }

    @Test
    public void test() {
        String s = "23";
        List<String> list = letterCombinations2(s);
        System.out.println(list.toString());
    }


    public List<String> letterCombinations2(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"hkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> res = new ArrayList<>();
        search2(new StringBuilder(), digits, res, 0, map);
        return res;
    }

    private void search2(StringBuilder s,
                        String digits,
                        List<String> res,
                        int index,
                        Map<Character, String> map) {
        if (index == digits.length()) {
            res.add(s.toString());
            return;
        }
        String letter = map.get(digits.charAt(index));
        for (int i = 0; i < letter.length(); i++) {
            search2(s.append(letter.charAt(i)), digits, res, index + 1, map);
            s.deleteCharAt(s.length()-1);
        }
    }
}
