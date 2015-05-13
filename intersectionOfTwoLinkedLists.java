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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0;
        int len2 = 0;
        ListNode n1 = headA;
        ListNode n2 = headB;
        while(n1 != null){
            len1++;
            n1 = n1.next;
        }
        while(n2 != null){
            len2++;
            n2 = n2.next;
        }
        n1 = headA;
        n2 = headB;
        int diff = Math.abs(len1 - len2);
        if(len1 >= len2){
            while(diff > 0){
                n1 = n1.next;
                diff--;
            }
            while(n1 != null){
                if(n1 == n2) return n1;
                n1 = n1.next;
                n2 = n2.next;
            }
            return null;
        } else{
            while(diff > 0){
                n2 = n2.next;
                diff--;
            }
            while(n1 != null){
                if(n1 == n2) return n1;
                n1 = n1.next;
                n2 = n2.next;
            }
            return null;
        }
    }
}