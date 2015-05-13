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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) return res;
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        ArrayList<Integer> levelRes = new ArrayList<Integer>();
        int count = 1;
        int nextCount = 0;
        q.add(root);
        while(!q.isEmpty()){
            TreeNode cur= q.poll();
            levelRes.add(cur.val);
            count--;
            if(cur.left != null){
                q.add(cur.left);
                nextCount++;
            }
            if(cur.right != null){
                q.add(cur.right);
                nextCount++;
            }
            
            if(count == 0){
                count = nextCount;
                nextCount = 0;
                res.add(0,levelRes);
                levelRes = new ArrayList<Integer>();
            }
        }
        return res;
    }
}