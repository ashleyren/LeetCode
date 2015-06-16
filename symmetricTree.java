// 和sametree很相似
// 先比较根是否相等,相等才能继续比下去,然后比较子树是否对称.递归调用
public boolean isSymmetric(TreeNode root) {
    if(root == null) return true;
    return helper(root.left, root.right);
}
private boolean helper(TreeNode p, TreeNode q){
    if(p == null && q == null) return true;
    if(p == null || q == null) return false;
    if(p.val != q.val) return false;
    return helper(p.left,q.right) && helper(p.right,q.left);
}