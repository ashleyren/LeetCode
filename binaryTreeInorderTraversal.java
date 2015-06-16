// 非递归的方法!这个太妙了!使用一个stack来帮助模拟中序遍历.
// 所以算法时间复杂度也是O(n)，空间复杂度是栈的大小O(logn)
public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> s = new Stack<TreeNode>();
        while(!s.isEmpty() || root != null){
            // if it is not null, push to stack
            //and go down the tree to left
            if(root!= null){
                s.push(root);
                root = root.left;
            }else{
            // if no left child
            // pop stack, process the node
            // then let p point to the right
                root = s.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

//递归 算法的时间复杂度是O(n), 而空间复杂度则是递归栈的大小，即O(logn)
public ArrayList<Integer> inorderTraversal(TreeNode root) {
    ArrayList<Integer> res = new ArrayList<Integer>();
    helper(root, res);
    return res;
}
private void helper(TreeNode root, ArrayList<Integer> res)
{
    if(root == null)
        return;
    helper(root.left,res);
    res.add(root.val);
    helper(root.right,res);
}

//morris 方法 太厉害了!!!
/*
算法具体分情况如下：
1. 如果当前结点的左孩子为空，则输出当前结点并将其当前节点赋值为右孩子。
2. 如果当前节点的左孩子不为空，则寻找当前节点在中序遍历下的前驱节点（也就是当前结点左子树的最右孩子）。接下来分两种情况：
 a) 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点（做线索使得稍后可以重新返回父结点）。然后将当前节点更新为当前节点的左孩子。
 b) 如果前驱节点的右孩子为当前节点，表明左子树已经访问完，可以访问当前节点。将它的右孩子重新设为空（恢复树的结构）。输出当前节点。当前节点更新为当前节点的右孩子。 
 
接下来我们来分析一下时间复杂度。咋一看可能会觉得时间复杂度是O(nlogn)，因为每次找前驱是需要logn，总共n个结点。
但是如果仔细分析会发现整个过程中每条边最多只走2次，一次是为了定位到某个节点，
另一次是为了寻找上面某个节点的前驱节点，而n个结点的二叉树中有n-1条边，
所以时间复杂度是O(2*n)=O(n)，仍然是一个线性算法。空间复杂度的话我们分析过了，只是两个辅助指针，所以是O(1)
*/
public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        TreeNode cur = root;
        while(cur != null){
            if(cur.left == null){
                res.add(cur.val);
                cur = cur.right;
            }else{
                TreeNode pre = cur.left;
                while(pre.right != null && pre.right != cur){
                    pre = pre.right;
                }
                if(pre.right == null){
                    pre.right = cur;
                    cur = cur.left;
                }else{
                    res.add(cur.val);
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }