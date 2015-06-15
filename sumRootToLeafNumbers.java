// 每一条递归的算.每找到下一个,之前的sum就*10
public class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    private int helper(TreeNode root, int sum){
        if(root == null) return 0;//这里不要写错.....代表没这个节点就不管了....
        if(root.left == null && root.right == null){
            return sum * 10 + root.val;
        }
        return helper(root.left, sum * 10 + root.val) + helper(root.right, sum * 10 + root.val);
    }
}