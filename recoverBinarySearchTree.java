
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
    TreeNode pre;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        pre = null;
        first = null;
        second = null;
        helper(root);
        if(first != null && second != null){
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }
    private void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        if(pre != null && pre.val > root.val){
            if(first == null){
                first = pre;
            }
            second = root;//啊这个每次就赋值，因为如果只有两个点的时候 设想一下极端情况所以不能if。。else。。。恩
        }
        pre = root;
        helper(root.right);
    }
}