/*
思路一
根据BST的定义，中序遍历的结果应该是递增的，所以我们中序遍历这一棵树，
保存上一次访问的(previous)结点，逐个检测递增关系即可。
java没有传入引用的概念，所以使用了一个ArrayList来存储。

思路二
对每个结点保存上限和下限。
具体为：左子树的所有结点都比当前结点小（左边结点的上限有了），右子数的节点都比当前节点大（右边结点的下限有了）。
根节点的界限不知道，初始就用最大值为上限，最小值为下限。
递归访问的时候，如果不在上下界限内，就返回false;
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        ArrayList<Integer> pre = new ArrayList<Integer>();
        pre.add(null);
        return helper(root,pre);
    }
    public boolean helper(TreeNode root, ArrayList<Integer> pre){
        if( root == null ) return true;
        boolean left = helper(root.left, pre);
        if(pre.get(0) != null && pre.get(0) >= root.val){
            return false;
        }
        pre.set(0,root.val);
        return left && helper(root.right, pre);
    }
}

//方法2： 才真是巧妙，因为设置了上下限为Integer.MIN_VALUE MAX_VALUE 这个就要考虑到边界的情况了！
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean helper(TreeNode root, int min, int max){
        if(root == null) return true;
        if((root.val == Integer.MIN_VALUE && root.left != null) ||
           (root.val == Integer.MAX_VALUE && root.right != null)) return false;
        if(root.val < min || root.val > max) return false;
        boolean left = helper(root.left, min, root.val-1);
        boolean right = helper(root.right, root.val+1, max);
        return left && right;
    }
}