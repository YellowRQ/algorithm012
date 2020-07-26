/**
 * ClassName:_98IsValidBST
 * Package:PACKAGE_NAME
 * Description:
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *  假设一个二叉搜索树具有如下特征：
 *  节点的左子树只包含小于当前节点的数。
 *  节点的右子树只包含大于当前节点的数。
 *  所有左子树和右子树自身必须也是二叉搜索树。
 *  示例 1:
 *  输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 *  示例 2:
 *  输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * @author:YellowRQ
 * @data:2020/7/26 18:46
 */
public class _98IsValidBST {


    /**
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * 递归
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return recurse(root, null, null);
    }

    private boolean recurse(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        if (lower != null && node.val <= lower) return false;
        if (upper != null && node.val >= upper) return false;

        if (!recurse(node.left, lower, node.val)) return false;
        if (!recurse(node.right, node.val, upper)) return false;
        return true;
    }


    // 定义 pre 作为每一个环节比较的最小值。
    Integer pre = null;
    /**
     * 中序遍历
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        // 如果根节点为空，直接返回 true 。
        if (root == null) {
            return true;
        }
        // 递归优先访问左子树。
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点，有效二叉搜索树当前节点的值应该大于所有左子树的值。
        if (pre != null && root.val <= pre) {
            return false;
        }
        // 将前一环节的最大值赋值给 pre ，作为下一环节比较的最小值。
        pre = root.val;
        // 最后访问右子树。
        return isValidBST(root.right);
    }

}
