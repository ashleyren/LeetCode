/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode n = fakeHead;;
        while(n.next != null){
            if(n.next.val == val){
                ListNode next = n.next.next;
                n.next = next;
            }else{
                n = n.next;
            }
        }
        return fakeHead.next;
    }
}