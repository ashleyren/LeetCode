/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode n = head;
        if(head == null) return null;
        if(head.next == null) return head;
        else{
            while(n.next != null && n != null){
            if(n.val == n.next.val){
                n.next = n.next.next;
            }else{
                n = n.next;
            }
        }
        return head;
        }
        
        
    }
}