/*
私以为这个代码更好理解.
重点就在于怎么把这个进入栈的过程想出来。
出栈的过程肯定是后序遍历的 那么压入栈的时候 只要是根 肯定先压入，
然后再把左边的压入 是叶子弹出。没有左子了 压入右子，在看右子是不是有左。。。。
开一个Stack，由于root结点是最后访问的结点，所以我们先将root结点push到Stack中

我们写一个while循环，while循环结束的条件是栈中没有任何结点。

当栈中有结点的时候，我们将取出栈顶结点

1、判断下它是否是叶子结点（left和right都为null）, 如果是叶子结点的话，那么不好意思，把它弹出栈，
并把值add到ArrayList中，如果不是叶子结点的话，那么

2、我们判断下它的left（node.left）是否为null,如果不为null，把它的左孩子结点push到栈中来，
并把它的左孩子域设为null, 然后跳过此次循环剩下的部分

3、如果它的left 为null, 把它的右孩子结点push到栈中来，并把右孩子域设为null，然后跳过此次循环剩下的部分！
*/
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.peek();
            if(cur.left == null && cur.right == null){
                res.add(cur.val);
                stack.pop();
            }else if(cur.left != null){
                stack.push(cur.left);
                cur.left = null;
                continue;
            }else if(cur.right != null){
                stack.push(cur.right);
                cur.right = null;
                continue;
            }
        }
        return res;
    }
}

//code ganker
// 1）如果当前栈顶元素的右结点存在并且还没访问过（也就是右结点不等于上一个访问结点），那么就把当前结点移到右结点继续循环；
// 2）如果栈顶元素右结点是空或者已经访问过，那么说明栈顶元素的左右子树都访问完毕，应该访问自己继续回溯了。
public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    if(root == null)
    {
        return res;
    }
    LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
    TreeNode pre = null;
    while(root != null || !stack.isEmpty())
    {
        if(root!=null)
        {
            stack.push(root);
            root = root.left;
        }
        else
        {
            TreeNode peekNode = stack.peek();
            if(peekNode.right!=null && pre != peekNode.right)
            {
                root = peekNode.right;
            }
            else
            {
                stack.pop();
                res.add(peekNode.val);
                pre = peekNode;
            }
        }
    }
    return res;
}