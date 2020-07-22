import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName:_590Postorder
 * Package:PACKAGE_NAME
 * Description:
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * @author:YellowRQ
 * @data:2020/7/23 3:30
 */
public class _590Postorder {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper (Node root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            for (Node child : root.children) {
                helper(child, res);
            }
        }
    }

    public List<Integer> preorder2(Node root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node cur = stack.pop();
            res.add(cur.val);
            for(int i = cur.children.size()-1; i >= 0; i--) {
                stack.push(cur.children.get(i));
            }
        }
        return res;
    }
}
