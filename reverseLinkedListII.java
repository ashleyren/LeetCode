/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m > n || m < 1){
            return null;
        }
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode pre = helper;
        int i = 1;
        while(pre.next != null && i < m){
            pre = pre.next;
            i++;
        }
        ListNode mNode = pre.next;
        ListNode cur = mNode.next;
        while(cur != null && i < n){
            ListNode tmp = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            mNode.next = tmp;
            cur = tmp;
            i++;
        }
        return helper.next;
    }
}