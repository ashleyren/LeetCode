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