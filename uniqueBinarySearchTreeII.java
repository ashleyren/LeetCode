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
    public ArrayList<TreeNode> generateTrees(int n) {
        return helper(1,n);
    }
    private ArrayList<TreeNode> helper(int left, int right){
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if(left > right){
            res.add(null);
            return res;
        }
        for(int i = left; i <= right; i++){
            ArrayList<TreeNode> lefts = helper(left,i-1);
            ArrayList<TreeNode> rights = helper(i+1, right);
            for(int k = 0; k < lefts.size(); k++){
                for(int j = 0; j < rights.size(); j++){
                    TreeNode root = new TreeNode(i);
                    root.left = lefts.get(k);
                    root.right = rights.get(j);
                    res.add(root);
                }
            }
        }
        return res;
    }
}