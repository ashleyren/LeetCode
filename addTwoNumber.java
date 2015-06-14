// 这题是一个简单版 recursive迭代的方法。每次传入两个head节点 和carry位
//进阶 参考career cup第五版 2.5
当顺序相反的时候要怎么做.
我想到的是先把两个LinkedList逆序,然后使用这个顺序的方法 最后再把结果逆序.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode l3 = head;
        
        while(l1 !=null || l2 !=null){
            if( l1 != null){
                carry += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                carry += l2.val;
                l2 = l2.next;
            }
            
            l3.next = new ListNode(carry % 10);
            carry = carry / 10;
            l3 = l3.next;
        }
        if(carry >= 1) {
            l3.next = new ListNode(carry);
        }
        return head.next;
    }
}