public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(n < 0) return res;
        if(n == 0){
            res.add(0);
            return res;
        }
        res = grayCode(n-1);
        int addNum = 1 << (n-1);
        int lastSize = res.size();
        for(int i = lastSize-1;i >= 0;i--){
            res.add(res.get(i) + addNum);
        }
        return res;
    }
}