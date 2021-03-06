public class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(rowIndex < 0) return res;
        res.add(1);
        for(int i = 1; i <= rowIndex; i++){
            res.add(1);
            for(int j = res.size() -2 ;j>=1;j--){
                res.set(j,res.get(j)+res.get(j-1));
            }
        }
        return res;
    }
}