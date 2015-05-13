/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode node = root.next;
        while(node != null){
            if(node.left != null){
                node = node.left;
                break;
            }
            if(node.right != null){
                node = node.right;
                break;
            }
            node = node.next;
        }
        if(root.left != null){
            if(root.right != null){
                root.left.next = root.right;
            }else{
                root.left.next = node;
            }
        }
        if(root.right != null){
            if(root.next != null){
                root.right.next = node;
            }
        }
        
        connect(root.right);
        connect(root.left);

        
    }
}