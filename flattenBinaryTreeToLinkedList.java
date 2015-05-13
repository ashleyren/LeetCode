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
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> pre  = new ArrayList<TreeNode>();
        pre.add(null);
        helper(pre,root);
    }
    private void helper(ArrayList<TreeNode> pre, TreeNode root){
        if(root == null) return;
        TreeNode realRight = root.right;
        if(pre.get(0) != null){
            pre.get(0).left = null;
            pre.get(0).right = root;
        }
        pre.set(0,root);
        helper(pre,root.left);
        helper(pre,realRight);
    }
}