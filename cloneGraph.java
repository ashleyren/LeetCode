//BFS广度优先遍历

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return null;
        }
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        //这个在外面建立是因为！最后要返回啊！！不然在while里面也可以的！
        map.put(node, copy);
        queue.add(node);
        while(!queue.isEmpty()){
            
            UndirectedGraphNode cur = queue.poll();
            
            for(UndirectedGraphNode n : cur.neighbors){
                if( !map.containsKey(n)){
                    copy = new UndirectedGraphNode(n.label);
                    map.put(n,copy);
                    queue.add(n);
                }
                //意思是把hashmap中cur对应的那个点的neighbors也加上。邻居就是cur邻居n在hm中对应的。
                map.get(cur).neighbors.add(map.get(n));
                
            }
        }
        return copy;//返回node的copy
    }
}
//DFS 深度优先遍历 -- 递归
//很棒很棒，主要就是注意两个图都存在hashmap里面，所以对hm做完操作，返回copy就可以所以DFS是返回void的

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        HashMap<UndirectedGraphNode,UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        hm.put(node,copy);
        DFS(hm,node);
        return copy;
    }
    private void DFS(HashMap<UndirectedGraphNode,UndirectedGraphNode> hm, UndirectedGraphNode node){
        if(node == null) return;
        for(UndirectedGraphNode n : node.neighbors){
            if(!hm.containsKey(n)){
                UndirectedGraphNode copy = new UndirectedGraphNode(n.label);
                hm.put(n,copy);
                DFS(hm,n);
            }
            hm.get(node).neighbors.add(hm.get(n));//这个和BFS很相似，唯一值得一提的就是这里了，注意DFS每次就是对一个点进行操作
            //具体就是，对node的copy 加上neibghbors， 邻居是什么呢？ 是node.neighbors ---》n 在hashmap对应的点。
        }
    }
}

//DFS 深度优先遍历 使用stack，每次就压如stack, 当stack为空就结束。。。其他的和前两种方法很相似
//wait..这是广度优先遍历把....

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        hm.put(node, copy);
        Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
        stack.push(node);
        while(!stack.isEmpty()){
            UndirectedGraphNode cur = stack.pop();
            for(UndirectedGraphNode n : cur.neighbors){
                if(!hm.containsKey(n)){
                    UndirectedGraphNode tmp = new UndirectedGraphNode(n.label);
                    hm.put(n,tmp);
                    stack.push(n);//压入stack也记得，是需要压的时候再压。。。

                }
                hm.get(cur).neighbors.add(hm.get(n));
            }
        }
        return copy;
    }
}