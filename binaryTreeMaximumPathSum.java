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
        res[0] = Integer.MIN_VALUE;
        helper(root,res);
        return res[0];
    }
    
    private int helper(TreeNode root, int[] res){
        if(root == null) return 0;
        int left = helper(root.left,res);
        int right = helper(root.right,res);
        int ans = Math.max(root.val, Math.max(left,right) + root.val);
        int maxSum = Math.max(ans,root.val+left+right);
        res[0] = Math.max(res[0],maxSum);
        return ans;
    }
}