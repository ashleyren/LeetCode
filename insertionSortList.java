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
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return head;
        ListNode res =  new ListNode(0);
        ListNode pre = res;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            pre = res;
            while(pre.next != null && pre.next.val <= cur.val){
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return res.next;
    }
}