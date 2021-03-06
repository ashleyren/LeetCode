// 第一种写法最简单粗暴 注意else if 改进一下之后更好 和第二种方法就差不多了.
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode fakehead = new ListNode(0);//fakehead
        ListNode pre = fakehead;
        while(l1 != null || l2 != null){
            if(l1 == null){
                pre.next = l2;
                break;//改进的地方 直接返回了
            }else if(l2 == null){
                pre.next = l1;
                break;//改进的地方 直接返回了
            }else if(l1.val > l2.val){
                pre.next = l2;
                l2 = l2.next;
            }else{
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }
        return fakehead.next;
    }
}

//or
private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        if (head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }

        return dummy.next;
    }