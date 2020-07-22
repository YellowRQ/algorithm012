import java.util.List;

/**
 * ClassName:Node
 * Package:PACKAGE_NAME
 * Description:
 *  N叉树
 * @author:YellowRQ
 * @data:2020/7/23 3:30
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
