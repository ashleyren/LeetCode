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
        ListNode fakehead = new ListNode(-1);
        fakehead.next = head;
        ListNode cur = head;
        ListNode prev = fakehead;
        while(cur != null){
            boolean flag = false;
            while(cur.next != null && cur.val == cur.next.val){
                flag = true;
                cur = cur.next;
            }
            if(flag == true){
                prev.next = cur.next;
            }else{
                prev = cur;
            }
            cur = cur.next;
        }
        return fakehead.next;
        
        
    }
}