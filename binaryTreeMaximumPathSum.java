/*
是这样想的,res存的是倒v字形,经过当前节点的路径的最大值,可以想象,这里一条路怎么都得是半个v字形或者一整个倒v字形
那么最大路径和变成了经过该点的左子树最大和与右子树最大和.
结果可以是1.当前点 2.max(左子树和,右子树和)+当前点. 如果max(左,右)为负,就只要当前点了.
helper的返回值值得一说,就是返回往max(左子树走max,右子树走max)单程的.*/
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
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        int[] res = new int[1];
        res[0] = root.val;
        helper(root,res);
        return res[0];
    }
    
    private int helper(TreeNode root, int[] res){
        if(root == null) return 0;//这一步别写错.这个的意思就是当前节点为空,^经过他的路径的值肯定为0
        int left = helper(root.left,res);
        int right = helper(root.right,res);
        int ans = Math.max(root.val, Math.max(left,right) + root.val);
        int maxSum = Math.max(ans,root.val+left+right);
        res[0] = Math.max(res[0],maxSum);
        return ans;
    }
}