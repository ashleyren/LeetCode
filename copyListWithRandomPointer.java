/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
// solution 1
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head,newHead);
        RandomListNode n = head.next;
        RandomListNode pre = newHead;
        while(n != null){
            RandomListNode newNode = new RandomListNode(n.label);
            pre.next = newNode;
            map.put(n,newNode);
            n = n.next;
            pre = newNode;
        }
        n = head;
        while(n!= null){
            RandomListNode node = map.get(n.random);
            RandomListNode cur = map.get(n);
            cur.random = node;
            n = n.next;
        }
        return newHead;
    }
}
//solution 2
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode n = head;
        while(n != null){
            RandomListNode newNode = new RandomListNode(n.label);
            newNode.next = n.next;
            n.next = newNode;
            n = newNode.next;
        }
        n = head;
        while(n != null){
            if(n.random != null){
                n.next.random = n.random.next;
            }
            n = n.next.next;
        }
        RandomListNode newHead = head.next;
        n = head;
        while(n != null){
            RandomListNode newNode = n.next;
            n.next = newNode.next;
            if(newNode.next != null){
                newNode.next = newNode.next.next;
            }
            n = n.next;
        }
        return newHead;
    }
}

