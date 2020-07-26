import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
/**
 * ClassName:_22GenerateParenthesis
 * Package:PACKAGE_NAME
 * Description:
 * 数字 n 代表生成括号的对数，请你设计一个函数，
 * 用于能够生成所有可能的并且 有效的 括号组合。
 *  示例：
 *  输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 * @author:YellowRQ
 * @data:2020/7/26 17:59
 */
public class _22GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        //filter the invalid s 左括号可以随时加，只要别超标； left>right
        generate(0,0, n, "", res);
        return res;
    }

    private void generate(int left, int right, int n, String s, List<String> res) {
        // terminator
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        // process current logic : left/right

        // drill down
        if (left < n) {
            generate(left + 1, right, n, s + "(", res);
        }
        if (left > right) {
            generate(left, right + 1, n, s + ")", res);
        }

        // reverse states
    }

    @Test
    public void test1() {
        List<String> strings = generateParenthesis(3);
        System.out.println(strings.toString());
    }
}
