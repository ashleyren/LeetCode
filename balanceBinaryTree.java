// 算法的时间是一次树的遍历O(n)，空间是栈高度O(logn)
//使用一个helper 当两边相等返回高度,不等的时候返回-1
// 注意读题,两边高度相差值小于等于1都是平衡树
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
    public boolean isBalanced(TreeNode root) {
        if(helper(root) == -1) {
            return false;
        } else {
            return true;
        }
    }
    
    private int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if(left == -1 || right == -1){
            return -1;
        }
        if(Math.abs(left - right) > 1){
            return -1;
        } 
        return Math.max(left, right) + 1;
    }
    
}