// 要注意的地方就是,左子树彻底为空时,就不算在内了,要计算右子树的深度了.
public int minDepth(TreeNode root) {
    if(root == null) return 0;
    if(root.left == null) return minDepth(root.right) + 1;
    if(root.right == null) return minDepth(root.left) + 1;
    return Math.min(minDepth(root.right), minDepth(root.left)) + 1;
}

//非递归如何实现?
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        int level = 1;
        q.offer(root);
        int lastCount = 1;
        int curCount = 0;
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            lastCount--;
            if(cur.left == null && cur.right == null){
                return level;
            }
            if(cur.left != null){
                q.offer(cur.left);
                curCount++;
            }
            if(cur.right != null){
                q.offer(cur.right);
                curCount++;
            }
            if(lastCount == 0){
                lastCount = curCount;
                curCount = 0;
                level++;
            }
        }
        return 0;
    }
}