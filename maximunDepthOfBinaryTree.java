public int maxDepth(TreeNode root) {
    if(root == null) return 0;
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    return 1+Math.max(left,right);
}
//非递归实现BFS啦
public int maxDepth(TreeNode root) {
    if(root == null) return 0;
    LinkedList<TreeNode> q = new LinkedList<TreeNode>();
    q.offer(root);
    int level = 0;
    int size = 0;
    while(!q.isEmpty()){
        size = q.size();
        while(size > 0){
            TreeNode cur = q.poll();
            if(cur.left != null){
                q.offer(cur.left);
            }
            if(cur.right != null){
                q.offer(cur.right);
            }
            size--;
        }
        level++;
    }
    return level;
}