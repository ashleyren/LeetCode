基本思路是，按层来获得结果，每层是一个list<Integer>, 那么就主要要界定每层有多少个元素。
使用广度优先遍历BFS，把每个节点加入queue。第一次 第一层就是root，size是1，
每一次 获得当前队列大小--》就是这一层结点的数量，循环访问这一层，依次取出这层每个点，将每个节点的值加入arraylist，在将它的左右孩子加入到队列。
这一层访问完毕，把arraylist的结果添加入结果之中，再进行下一层的循环。下一层队节点的数量是多少呢？是当前队列的size。

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) return res;
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int curNum = 0;
        int lastNum = 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            lastNum--;
            list.add(cur.val);
            if(cur.left != null){
                q.add(cur.left);
                curNum++;
            }
            if(cur.right != null){
                q.add(cur.right);
                curNum++;
            }
            if(lastNum == 0){
                res.add(list);
                lastNum = curNum;
                curNum = 0;
                list = new ArrayList<Integer>();
            }
        }
        return res;
    }
}
//再一次自己写的 感觉比较好懂一些。
public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return res;
        }
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int size = 1;
        while(!q.isEmpty()){
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                list.add(cur.val);
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
            }
            res.add(list);
            size = q.size();
        }
        return res;
    }