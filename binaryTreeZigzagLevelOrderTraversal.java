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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) return res;
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        ArrayList<Integer> levelRes;
        q.add(root);
        boolean reverse = false;
        while(!q.isEmpty()){
            int num = q.size();
            levelRes = new ArrayList<Integer>();
            for(int i = 0; i < num; i++){
                TreeNode n = q.poll();
                levelRes.add(n.val);
                if(n.left != null){
                    q.add(n.left);
                }
                if(n.right != null){
                    q.add(n.right);
                }
            }
            if(reverse) Collections.reverse(levelRes);
            reverse = !reverse;
            res.add(levelRes);
        }
        return res;
    }
}