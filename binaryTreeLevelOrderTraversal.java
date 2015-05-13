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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) return res;
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int curNum = 0;
        int lastNum = 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            lastNum--;
            list.add(cur.val);
            if(cur.left != null){
                q.add(cur.left);
                curNum++;
            }
            if(cur.right != null){
                q.add(cur.right);
                curNum++;
            }
            if(lastNum == 0){
                res.add(list);
                lastNum = curNum;
                curNum = 0;
                list = new ArrayList<Integer>();
            }
        }
        return res;
    }
}