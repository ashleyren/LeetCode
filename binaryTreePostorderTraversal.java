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