/**
 * ClassName:RecursionTemplate
 * Package:PACKAGE_NAME
 * Description:
 * 递归模版
 * @author:YellowRQ
 * @data:2020/7/26 19:11
 */
public class RecursionTemplate {

    private static final int MAX_LEVEL = 1;

    public void rec(int level, int param) {
        // 终止条件
        if (level >= MAX_LEVEL) {
            //process
            return;
        }
        //处理当前逻辑
        //向下
        int newParam = 0;
        rec(level + 1, newParam);

        //清理当前层
    }
}
