public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        int n = triangle.size();
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = triangle.get(n-1).get(i);
        }
        for(int i = n-2; i>=0;i--){
            for(int j = 0; j <= i;j++){
                res[j] = Math.min(res[j],res[j+1]) + triangle.get(i).get(j);
            }
        }
        return res[0];
    }
}