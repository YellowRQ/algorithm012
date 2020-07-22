import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName:_94InorderTraversal
 * Package:PACKAGE_NAME
 * Description:
 *  给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * @author:YellowRQ
 * @data:2020/7/21 1:54
 */
public class _94InorderTraversal {

    /**
     * 递归 O(n)
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    private void inOrder(TreeNode root, List<Integer> resList) {
        if (root == null) {
            return;
        }
        inOrder(root.left, resList);
        resList.add(root.val);
        inOrder(root.right, resList);
    }

    /**
     * 模拟栈迭代
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null && !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
