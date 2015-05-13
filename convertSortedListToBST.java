/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    private static ListNode h;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        int len = 0;
        h = head;
        while(head != null){
            head = head.next;
            len++;
        }
        return helper(0, len - 1);
    }
    
    private TreeNode helper(int start, int end){
        if(start > end) return null;
        int mid = (start + end)/2;
        TreeNode left = helper(start, mid - 1);
        TreeNode root = new TreeNode(h.val);
        root.left = left;
        h = h.next;
        root.right = helper(mid + 1, end);
        return root;
    }
}