/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode leftHead = new ListNode(0);
        ListNode left = leftHead;
        ListNode rightHead = new ListNode(0);
        ListNode right = rightHead;
        while(head != null){
            if(head.val < x){
                left.next = head;
                left = left.next;
            }else{
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        left.next = rightHead.next;
        right.next = null;
        return leftHead.next;
    }
}