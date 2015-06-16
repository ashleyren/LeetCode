// 递归,就判断当前点是否相等,在递归调用判断左子树和右子树 时间复杂度是O(n)，空间复杂度是O(logn)
public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p == null && q == null) return true;
    if(p == null || q == null) return false;//这里写的很妙啊 刚开始我写的巨复杂...
    if(p.val == q.val){
        return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
    }else{
        return false;
    }
}