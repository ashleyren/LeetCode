public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        if(n == 0) return res;
        helper(res,new String(),n,n);
        return res;
    }
    private void helper(ArrayList<String> res, String item, int left, int right){
        if(left > right){
            return;
        }
        if(left == 0 && right == 0){
            res.add(item);
            return;
        }
        if(left > 0){
            helper(res,item+"(",left-1,right);
        }
        if(right > 0){
            helper(res,item+")",left,right-1);
        }
    }
}