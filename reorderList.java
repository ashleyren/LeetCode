/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverse(head2);
        ListNode head1 = head;
        while(head1 != null && head2 != null){
            ListNode next1 = head1.next;
            ListNode next2 = head2.next;
            head1.next = head2;
            head2.next = next1;
            head1 = next1;
            head2 = next2;
        }
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        return reverse(head, head.next);
    }
    private ListNode reverse(ListNode n1, ListNode n2){
        if(n2 == null) return n1;
        ListNode newHead = reverse(n2,n2.next);
        n2.next = n1;
        n1.next = null;
        return newHead;
    }
}