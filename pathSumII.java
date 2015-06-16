/*
典型的使用helper的记录路径的题目
所以我们需要数据结构来维护中间路径结果以及保存满足条件的所有路径。
这里的时间复杂度仍然只是一次遍历O(n)，而空间复杂度则取决于满足条件的路径和的数量（假设是k条），则空间是O(klogn)
*/
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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) return res;
        ArrayList<Integer> item = new ArrayList<Integer>();
        item.add(root.val);
        helper(root,sum-root.val,res,item);
        return res;
    }
    private void helper(TreeNode root, int sum, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> item){
        if(root == null ){
            return;
        }
        if(root.left == null && root.right == null && sum == 0){
                res.add(new ArrayList<Integer>(item));
                return;
            
        }
        if(root.left != null){
            item.add(root.left.val);
            helper(root.left, sum - root.left.val, res, item);
            item.remove(item.size()-1);//回溯
        }
        
        if(root.right != null){
            item.add(root.right.val);
            helper(root.right, sum - root.right.val, res, item);
            item.remove(item.size()-1);//回溯
        }
        
    }
}