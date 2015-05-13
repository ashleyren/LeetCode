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
                //始终要做这一部拷贝的，不管你在不在里面。
                map.get(cur).neighbors.add(map.get(n));
                
            }
        }
        return map.get(node);
    }
}