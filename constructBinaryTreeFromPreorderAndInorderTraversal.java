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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0 , preorder.length-1, inorder, 0, inorder.length-1);
    }
    private TreeNode helper(int[] preorder,int pre_start, int pre_end, int[] inorder, int in_start, int in_end){
        if(pre_start > pre_end || in_start > in_end){
            return null;
        }
        int value = preorder[pre_start];
        TreeNode root = new TreeNode(value);
        int index = in_start;
        while(index <= in_end){
            if(inorder[index] == value){
                break;
            }
            index++;
        }
        int len = index - in_start;
        root.left = helper(preorder, pre_start + 1, pre_start + len , inorder, in_start, in_start + len -1);
        root.right = helper(preorder, pre_start + len + 1, pre_end, inorder, in_start+ len + 1, in_end);
        return root;
    }
}