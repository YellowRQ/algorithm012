package leetcode;

import org.junit.Test;

/**
 * ClassName:PathSum
 * Package:one
 * Description:
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 *  说明: 叶子节点是指没有子节点的节点。
 *
 *  示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *                5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 *
 *
 *  返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *  Related Topics 树 深度优先搜索
 *  👍 372 👎 0
 * @author:YellowRQ
 * @data:2020/7/7 23:28
 */
public class PathSum {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        boolean a = hasPathSum(root.left, sum - root.val);
        boolean b = hasPathSum(root.right, sum - root.val);

        return a || b;
    }

    /**
     *  *
     *  *                5A
     *  *               / \
     *  *             4B   8C
     *  *            /    /   \
     *  *           11D  13E  4F
     *  *           /  \        \
     *  *         7G    2H        1I
     */
    @Test
    public void codeTest() {
        TreeNode A = new TreeNode(5);
        TreeNode B = new TreeNode(4);
        TreeNode C = new TreeNode(8);
        TreeNode D = new TreeNode(11);
        TreeNode E = new TreeNode(13);
        TreeNode F = new TreeNode(4);
        TreeNode G = new TreeNode(7);
        TreeNode H = new TreeNode(2);
        TreeNode I = new TreeNode(1);
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = null;
        C.left = E;
        C.right = F;
        D.left = G;
        D.right = H;
        E.left = E.right = null;
        F.left = null;
        F.right = I;
        G.left = G.right = I.left = I.right = null;
        System.out.println(hasPathSum(A, 22));
    }
}
