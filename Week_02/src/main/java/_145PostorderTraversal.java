import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName:_145PostorderTraversal
 * Package:PACKAGE_NAME
 * Description:
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 *  示例:
 *
 *  输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * @author:YellowRQ
 * @data:2020/7/23 3:12
 */
public class _145PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res) ;
        return res;
    }

    private void postOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.val);
    }


    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(0,root.val);
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;

        }
        return res;
    }
}
