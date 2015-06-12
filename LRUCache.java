/*终于ac了！做的我快哭了！！这到底简直是双向链表的神题啊。模型难想，代码不那么好写，概念考的多。
首先读题
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

LRU是怎么一回事呢？
 “为了能够快速删除最久没有访问的数据项和插入最新的数据项，我们用双向链表来连接Cache中的数据项，并且保证链表维持数据项从最近访问到最旧访问的顺序。 
 每次数据项被查询到时，都将此数据项移动到链表头部（O(1)的时间复杂度）。这样，在进行过多次查找操作后，最近被使用过的内容就向链表的头移动，
 而没 有被使用的内容就向链表的后面移动。当需要替换时，链表最后的位置就是最近最少被使用的数据项，
 我们只需要将最新的数据项放在链表头部，当Cache满 时，淘汰链表最后的位置就是了。 ”
 
根据题意：
get(key) 每次根据key获取，如果这个key在cache里面，就返回它对应的value； 如果不在的话就返回-1. 返回完毕之后，要知道 
这个点是最近访问的，肯定要把它作为latest recent used 存起来啊。所以呢，开始思考说，光一个hashmap好像解决不了问题。得有一个有先后顺序的东西
就想要了linkedlist。至于这里为什吗要用双向链表呢？
原因如下：
“首先是Cache中块的命中可能是随机的，和Load进来的顺序无关。
 其次，双向链表插入、删除很快，可以灵活的调整相互间的次序，时间复杂度为O(1)。”


 set(key,value)：当要set的key值已经存在，就更新其value， 将其在原链表中删除，然后将其作为头结点；
 当要set的key值不存在，就新建一个node，如果当前map.size<capacity,就将其加入hashmap中，并将其作为头结点;
 否则，删除链表最后一个node，再将其放入hashmap并作为头结点。
 */

public class LRUCache {
    HashMap<Integer,Node> map;// 注意类的属性都不要在这里赋值，要去构造函数里面赋初始值
    private int capacity;
    Node head;
    Node tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity; //构造函数赋值
        map = new HashMap<Integer, Node>();
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node cur = map.get(key);
            removeNode(cur);
            setHead(cur);
            return cur.value;
        }else{
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            
            Node cur = map.get(key);
            cur.value = value;
            removeNode(cur);
            setHead(cur);
        }else{
            Node cur = new Node(key,value);
            if(map.size() < capacity){
                setHead(cur);
            }else if(map.size() == capacity){
                map.remove(tail.key);
                tail = tail.pre;
                if(tail != null){
                    tail.next = null;
                }
                setHead(cur);
            }
            map.put(key,cur);

        }
    }
    
    private void setHead(Node node){
        node.next = head;
        node.pre = null;
        if(head != null){
            head.pre = node;
        }
        head = node;
        if(tail == null){
            tail = node;
        }
    }
    private void removeNode(Node node){
        if(node == null) return;
        if(node.pre != null){
            node.pre.next = node.next;
        }else{
            head = node.next;
        }
        if(node.next != null){
            node.next.pre = node.pre;
        }else{
            tail = node.pre;
        }
    }
    
    private class Node{
        Node pre;
        Node next;
        int key;
        int value;
        public Node(int key, int value){
            this.key = key; //同理 构造函数赋值
            this.value = value;
            this.next = null;
            this.pre = null;
        }
    }
    
}