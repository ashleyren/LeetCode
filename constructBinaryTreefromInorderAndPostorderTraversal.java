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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || 
        inorder.length == 0 || postorder.length == 0 || 
        inorder.length != postorder.length) return null;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return helper(inorder,0,inorder.length-1,postorder,0,inorder.length-1,map);
        
    }
    private TreeNode helper(int[] inorder,int inStart,int inEnd,
    int[] postorder,int poStart,int poEnd, 
    HashMap<Integer,Integer> map){
        if( inStart > inEnd || poStart > poEnd) return null;
        TreeNode root = new TreeNode(postorder[poEnd]);
        int mid = map.get(root.val);
        int len_left = mid - inStart;
        int len_right = inEnd - mid;
        root.left = helper(inorder,inStart,mid-1,postorder,poStart, poStart + len_left -1,map);//飘泪了都 这两步弄死我了！！！！
        root.right = helper(inorder,mid+1,inEnd,postorder, poEnd - len_right, poEnd-1,map);
        return root;
    }
}