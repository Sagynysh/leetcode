import java.util.Stack;

public class ResortTreeNode {

    public static void main(String[] args) {


    }

    public TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode result = null;
        TreeNode tmp = null;
        while(root!=null || stack.size()!=0){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(result == null){
                result = new TreeNode(root.val);
                tmp = result;
            }else{
                tmp.right = new TreeNode(root.val);
                tmp = tmp.right;
            }

            root = root.right;
        }
        return result;
    }
}
