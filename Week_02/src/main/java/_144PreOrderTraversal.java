import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName:_144PreOrderTraversal
 * Package:PACKAGE_NAME
 * Description:
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 *  输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * 输出: [1,2,3]
 * @author:YellowRQ
 * @data:2020/7/23 2:56
 */
public class _144PreOrderTraversal {

    /**
     * 遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return  res;
    }

    public void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop().right;
        }
        return res;
    }
}
