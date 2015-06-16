/*
思路是先分成两个子任务，然后递归求子任务，最后回溯回来。
这个题目也是这样，先把k个list分成两半，然后继续划分，知道剩下两个list就合并起来，合并时会用到Merge Two Sorted Lists这道题
假设总共有k个list，每个list的最大长度是n，那么运行时间满足递推式T(k) = 2T(k/2)+O(n*k)。
根据主定理，可以算出算法的总复杂度是O(nklogk)。空间复杂度的话是递归栈的大小O(logk)
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
/*
这种方法用到了堆的数据结构，思路比较难想到，但是其实原理比较简单。
维护一个大小为k的堆，每次取堆顶的最小元素放到结果中，然后读取该元素的下一个元素放入堆中，重新维护好。
因为每个链表是有序的，每次又是去当前k个元素中最小的，所以当所有链表都读完时结束，这个时候所有元素按从小到大放在结果链表中。
这个算法每个元素要读取一次，即是k*n次，然后每次读取元素要把新元素插入堆中要logk的复杂度，
所以总时间复杂度是O(nklogk)。空间复杂度是堆的大小，即为O(k)
*/
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0) return null;
        Comparator<ListNode> cmp;
        ListNode fakehead = new ListNode(0);
        ListNode n = fakehead;
        cmp = new Comparator<ListNode>() {
          public int compare(ListNode e1, ListNode e2) {//注意这里别写错,返回类型是int
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