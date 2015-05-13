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
//二分法
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0) return null;
        return helper(lists,0,lists.size()-1);
    }
    private ListNode helper(ArrayList<ListNode> lists, int l , int r){
        if(l<r){
            int mid = (l+r)/2;
            return merge(helper(lists,l,mid),helper(lists,mid+1,r));
        }
        return lists.get(l);
    }
    private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode fakehead = new ListNode(0);
        ListNode pre = fakehead;
        while(l1 != null || l2 != null){
            if(l1 == null){
                pre.next = l2;
                l2 = l2.next;
            }else if(l2 == null){
                pre.next = l1;
                l1 = l1.next;
            }else if(l1.val < l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        return fakehead.next;
    }
}
// 优先队列 heap法
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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0) return null;
        Comparator<ListNode> cmp;
        ListNode fakehead = new ListNode(0);
        ListNode n = fakehead;
        cmp = new Comparator<ListNode>() {
          public int compare(ListNode e1, ListNode e2) {
            return e1.val - e2.val;
          }
        };
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(11,cmp);
        for(int i = 0; i < lists.size(); i++){
            if(lists.get(i) != null) heap.add(lists.get(i));
        }
        while(!heap.isEmpty()){
            ListNode cur = heap.poll();
            n.next = cur;
            if(cur.next != null) heap.add(cur.next);
            n = n.next;
        }
        return fakehead.next;
    }
}