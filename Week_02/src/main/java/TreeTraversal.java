/**
 * ClassName:TreeTraversal
 * Package:PACKAGE_NAME
 * Description:
 *
 * @author:YellowRQ
 * @data:2020/7/23 2:41
 */
public class TreeTraversal {

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(root.left);
        System.out.print(root.val + " ");
        preOrder(root.right);
    }

    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }


}
