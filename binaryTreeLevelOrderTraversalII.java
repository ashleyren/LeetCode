//思路和I是一样的，要注意就是按照BFS每层结果要加入arraylist的头部。
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
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) return res;
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        q.add(root);
        int size = 1;
        while(!q.isEmpty()){
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                list.add(cur.val);
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
            }
            res.add(0,list);//这题的精华就在这一步 把结果加在arraylist的头部
            size = q.size();
            list = new ArrayList<Integer>();
        }

        return res;
    }
}